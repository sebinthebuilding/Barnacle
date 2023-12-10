package random.barnacle.ui.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import random.barnacle.domain.repositories.PriceRepository
import random.barnacle.domain.use_cases.PriceUseCase
import javax.inject.Inject


@HiltViewModel
class PricesViewModel @Inject constructor(
    private val priceRepository: PriceRepository,
) : ViewModel() {

    val usdcPriceUiState: MutableStateFlow<Map<String, Double>> = MutableStateFlow<Map<String, Double>>(emptyMap())

    val solPriceUiState: MutableStateFlow<Map<String, Double>> = MutableStateFlow<Map<String, Double>>(emptyMap())

    init {
        streamUsdcPriceUiState()
        streamSolPriceUiState()
    }

    private fun streamUsdcPriceUiState() {
        viewModelScope.launch {
            while (true) {
                val price = PriceUseCase(
                    priceRepository,
                ).gimmePricesInUsdc()

                usdcPriceUiState.emit(price)
            }
        }
    }

    private fun streamSolPriceUiState() {
        viewModelScope.launch {
            while (true) {
                val price = PriceUseCase(
                    priceRepository,
                ).gimmePricesInSol()

                solPriceUiState.emit(price)
            }
        }
    }
}
