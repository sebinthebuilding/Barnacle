package random.barnacle.ui.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import random.barnacle.App
import random.barnacle.data.PriceRepository
import random.barnacle.data.models.PriceResponse


// Android framework does not allow passed values in ViewModel constructor on it's creation. We need a Factory.
class PriceViewModel(private val priceRepository: PriceRepository, private val mSolAddress: String) : ViewModel() {
    lateinit var usdcPriceUiState: PriceResponse
        private set

    init {
        getUsdcPriceUiState()
    }

    private fun getUsdcPriceUiState() {
        viewModelScope.launch {
            usdcPriceUiState = priceRepository.getUsdcPrice(mSolAddress)
        }
    }
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as App)
                val priceRepository = application.container.priceRepository
                PriceViewModel(priceRepository = priceRepository, mSolAddress = "mSoLzYCxHdYgdzU16g5QSh3i5K3z3KZK7ytfqcJm7So")
            }
        }
    }
}
