package random.barnacle.ui.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import random.barnacle.domain.models.TokenModel
import random.barnacle.domain.repositories.TokensRepository
import random.barnacle.domain.use_cases.TokensUseCase
import javax.inject.Inject

@HiltViewModel
class TokensViewModel @Inject constructor(
    private val tokensRepository: TokensRepository
): ViewModel() {
    var allTokensUiState: List<TokenModel> = emptyList()

    init {
        getAllTokensUiState()
    }

    private fun getAllTokensUiState() {
        viewModelScope.launch {
            allTokensUiState = TokensUseCase(tokensRepository).getAllTokensUseCase()
        }
    }
}
