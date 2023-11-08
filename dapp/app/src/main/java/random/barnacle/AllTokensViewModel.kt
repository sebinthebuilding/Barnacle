package random.barnacle

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import random.barnacle.network.JupAgTokensApi
import random.barnacle.network.Token
import java.io.IOException

sealed interface AppUiState {
    data class Success(val tokens: String) : AppUiState
    object Error : AppUiState
    object Loading : AppUiState
}
class AllTokensViewModel : ViewModel() {
    var allTokensUiState: AppUiState by mutableStateOf(AppUiState.Loading)
        private set

    init {
        showAllTokens()
    }

    private fun showAllTokens() {
        viewModelScope.launch {
            allTokensUiState = try {
                val listResult = JupAgTokensApi.client.getAllTokens()
                AppUiState.Success(
                    listResult.size.toString()
                )
            } catch (e: IOException) {
                AppUiState.Error
            }
        }
    }
}