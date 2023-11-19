package random.barnacle.ui.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.launch
import random.barnacle.App
import random.barnacle.data.repositories.TokensRepository
import random.barnacle.domain.use_cases.TokensUseCase
import random.barnacle.domain.models.TokenModel

// Android framework does not allow passed values in ViewModel constructor on it's creation. We need a Factory.
class TokensViewModel(private val tokensRepository: TokensRepository) : ViewModel() {
    var allTokensUiState: List<TokenModel> = emptyList()

    var strictTokensUiState: List<TokenModel> = emptyList()

    init {
        getAllTokensUiState()
        getStrictTokensUiState()
    }

    private fun getAllTokensUiState() {
        viewModelScope.launch {
            allTokensUiState = TokensUseCase(tokensRepository).getAllTokensUseCase()
        }
    }

    private fun getStrictTokensUiState() {
        viewModelScope.launch {
            strictTokensUiState = TokensUseCase(tokensRepository).getStrictTokensUseCase()
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                TokensViewModel(tokensRepository = (this[APPLICATION_KEY] as App).container.tokensRepository)
            }
        }
    }
}
