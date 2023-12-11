package random.barnacle.ui.view_models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import random.barnacle.domain.QuoteCurrencies
import random.barnacle.domain.repositories.PriceRepository
import random.barnacle.domain.use_cases.PriceUseCase
import javax.inject.Inject


@HiltViewModel
class PricesViewModel @Inject constructor(
    private val priceRepository: PriceRepository,
) : ViewModel() {

    val allPricesUiState: MutableStateFlow<Map<String, Double>> = MutableStateFlow<Map<String, Double>>(emptyMap())

    var selectedQuoteCurrency by mutableStateOf(QuoteCurrencies.USDC)
        private set

    init {
        streamPrices(selectedQuoteCurrency.address)
    }

    fun selectQuoteCurrency(quoteCurrency: QuoteCurrencies) {
        selectedQuoteCurrency = quoteCurrency
        streamPrices(quoteCurrency.address)
    }

    private fun streamPrices(selectedQuoteCurrencyAddress: String) {
        viewModelScope.launch {
            while (true) {
                val allPrices = PriceUseCase(
                    priceRepository,
                ).gimmeAllPrices(selectedQuoteCurrencyAddress)

                allPricesUiState.emit(allPrices)
            }
        }
    }

    fun stopPriceStream() {
        viewModelScope.coroutineContext.cancelChildren()
    }

}
