package random.barnacle

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import random.barnacle.network.JupAgPriceApi
import random.barnacle.network.JupAgTokensApi

class BarnacleViewModel : ViewModel() {
    var barnacleUiState by mutableStateOf("")
        private set

    var ethSolPriceState by mutableStateOf("")
        private set

    init {
        showAllTokens()
        showEthSolPrice()
    }

    private fun showAllTokens() {
        viewModelScope.launch {
            val listResult = JupAgTokensApi.client.getAllTokens()
            barnacleUiState = listResult
        }
    }

    private fun showEthSolPrice() {
        viewModelScope.launch {
            val p = JupAgPriceApi.client.getEthSolPrice()
            ethSolPriceState = p
        }
    }
}