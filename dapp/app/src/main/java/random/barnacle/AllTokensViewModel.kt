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
import random.barnacle.data.NetworkTokensRepository
import random.barnacle.data.TokensRepository
import random.barnacle.network.AppApiService
import java.io.IOException

sealed interface AppUiState {
    data class Success(val tokens: String) : AppUiState
    object Error : AppUiState
    object Loading : AppUiState
}

// Android framework does not allow passed values in ViewModel constructor on it's creation. We need a Factory.
class AllTokensViewModel(private val allTokensRepository: TokensRepository) : ViewModel() {
    var allTokensUiState: AppUiState by mutableStateOf(AppUiState.Loading)
        private set

    init {
        getAllTokensUiState()
    }

    private fun getAllTokensUiState() {
        viewModelScope.launch {
            allTokensUiState = try {
                val listResult = allTokensRepository.getAllTokens()
                AppUiState.Success(
                    listResult.size.toString()
                )
            } catch (e: IOException) {
                AppUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as BarnacleApplication)
                val allTokensRepository = application.container.allTokensRepository
                AllTokensViewModel(allTokensRepository = allTokensRepository)
            }
        }
    }
}
