package random.barnacle.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import random.barnacle.data.repositories.PriceRepository
import random.barnacle.data.repositories.TokensRepository
import random.barnacle.domain.QuoteCurrencies
import random.barnacle.domain.models.TokenModel
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    private val tokensRepository: TokensRepository,
    private val priceRepository: PriceRepository
): ViewModel() {
    var allTokensUiState: List<TokenModel> = emptyList()

    val allPricesUiState: MutableStateFlow<Map<String, Double>> = MutableStateFlow<Map<String, Double>>(emptyMap())
    var selectedQuoteCurrency by mutableStateOf(QuoteCurrencies.USDC)
        private set

    fun selectQuoteCurrency(quoteCurrency: QuoteCurrencies) {
        selectedQuoteCurrency = quoteCurrency
    }

    init {
        getUiState()
    }

    private fun getUiState() {
        viewModelScope.launch {
            allTokensUiState = tokensRepository.gimmeAllTokens()
            val allAddresses = allTokensUiState.joinToString(",") { it.address }

            priceStream(allAddresses)
        }
    }

    private suspend fun priceStream(allAddresses: String) {
        val allPrices = priceRepository.gimmeAllPrices(allAddresses, selectedQuoteCurrency.address)
        allPricesUiState.emit(allPrices)
    }

    fun stopPriceStream() {
        viewModelScope.coroutineContext.cancelChildren()
    }
}
