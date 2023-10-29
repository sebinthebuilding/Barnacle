package random.barnacle

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import random.barnacle.network.BarnacleApi

class BarnacleViewModel : ViewModel() {
    var barnacleUiState by mutableStateOf("")
        private set

    init {
        getAllTokens()
    }

    private fun getAllTokens() {
        viewModelScope.launch {
            val listResult = BarnacleApi.retrofitService.getAllTokens()
            barnacleUiState = listResult
        }
    }
}