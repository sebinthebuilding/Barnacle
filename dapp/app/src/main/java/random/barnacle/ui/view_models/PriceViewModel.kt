package random.barnacle.ui.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import random.barnacle.App
import random.barnacle.data.repositories.PriceRepository
import random.barnacle.data.repositories.TokensRepository
import random.barnacle.domain.use_cases.PriceUseCase


// Android framework does not allow passed values in ViewModel constructor on it's creation, thus we need a Factory.
class PriceViewModel(private val priceRepository: PriceRepository, private val tokensRepository: TokensRepository) : ViewModel() {

    val usdcPriceUiState: MutableStateFlow<Map<String, Double>> = MutableStateFlow<Map<String, Double>>(emptyMap())

    init {
        streamUsdcPriceUiState()
    }

    private fun streamUsdcPriceUiState() {
        viewModelScope.launch {
            while (true) {
                val price = PriceUseCase(priceRepository, tokensRepository).getPrice()
                usdcPriceUiState.emit(price)
            }
        }
    }
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as App)
                val priceRepository = application.container.priceRepository
                val tokensRepository = application.container.tokensRepository
                PriceViewModel(priceRepository, tokensRepository)
            }
        }
    }
}
