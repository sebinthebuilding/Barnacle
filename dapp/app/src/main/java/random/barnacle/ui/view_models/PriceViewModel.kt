package random.barnacle.ui.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.launch
import random.barnacle.App
import random.barnacle.data.repositories.PriceRepository
import random.barnacle.data.models.PriceResponse


// Android framework does not allow passed values in ViewModel constructor on it's creation, thus we need a Factory.
class PriceViewModel(private val priceRepository: PriceRepository) : ViewModel() {

    val mSolAddress = "mSoLzYCxHdYgdzU16g5QSh3i5K3z3KZK7ytfqcJm7So"
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
                PriceViewModel(priceRepository = priceRepository)
            }
        }
    }
}
