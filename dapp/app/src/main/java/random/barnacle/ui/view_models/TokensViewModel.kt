package random.barnacle.ui.view_models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.launch
import random.barnacle.App
import random.barnacle.data.TokensRepository
import random.barnacle.data.models.TokenResponse
import java.io.IOException

sealed interface TokenUiState {
    data class Success(val tokenResponses: List<TokenResponse>) : TokenUiState
    object Error : TokenUiState
    object Loading : TokenUiState
}

// Android framework does not allow passed values in ViewModel constructor on it's creation. We need a Factory.
class TokensViewModel(private val tokensRepository: TokensRepository) : ViewModel() {
    var allTokensUiState: TokenUiState by mutableStateOf(TokenUiState.Loading)
        private set

    var strictTokensUiState: TokenUiState by mutableStateOf(TokenUiState.Loading)
        private set

    init {
        getAllTokensUiState()
        getStrictTokensUiState()
    }

    private fun getAllTokensUiState() {
        viewModelScope.launch {
            allTokensUiState = try {
                val listOfAllTokens = tokensRepository.getAllTokens()
                TokenUiState.Success(listOfAllTokens)
            } catch (e: IOException) {
                TokenUiState.Error
            }
        }
    }

    private fun getStrictTokensUiState() {
        viewModelScope.launch {
            strictTokensUiState = try {
                val listOfStrictTokens = tokensRepository.getStrictTokens()
                TokenUiState.Success(listOfStrictTokens)
            } catch (e: IOException) {
                TokenUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as App)
                val tokensRepository = application.container.tokensRepository
                TokensViewModel(tokensRepository = tokensRepository)
            }
        }
    }
}
