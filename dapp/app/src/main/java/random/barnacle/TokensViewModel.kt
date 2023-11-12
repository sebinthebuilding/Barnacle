package random.barnacle

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
import random.barnacle.data.TokensRepository
import random.barnacle.model.Token
import java.io.IOException

sealed interface AppUiState {
    data class Success(val count: String) : AppUiState
    object Error : AppUiState
    object Loading : AppUiState
}

// Android framework does not allow passed values in ViewModel constructor on it's creation. We need a Factory.
class TokensViewModel(private val tokensRepository: TokensRepository) : ViewModel() {
    var allTokensUiState: AppUiState by mutableStateOf(AppUiState.Loading)
        private set

    var strictTokensUiState: AppUiState by mutableStateOf(AppUiState.Loading)
        private set

    init {
        getAllTokensUiState()
        getStrictTokensUiState()
    }

    private fun getAllTokensUiState() {
        viewModelScope.launch {
            allTokensUiState = try {
                val listOfAllTokens = tokensRepository.getAllTokens()
                AppUiState.Success(listOfAllTokens.size.toString())
            } catch (e: IOException) {
                AppUiState.Error
            }
        }
    }

    private fun getStrictTokensUiState() {
        viewModelScope.launch {
            strictTokensUiState = try {
                val listOfStrictTokens = tokensRepository.getStrictTokens()
                AppUiState.Success(listOfStrictTokens.size.toString())
            } catch (e: IOException) {
                AppUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as BarnacleApplication)
                val tokensRepository = application.container.tokensRepository
                TokensViewModel(tokensRepository = tokensRepository)
            }
        }
    }
}
