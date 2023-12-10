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
class PriceViewModel @Inject constructor(
    private val priceRepository: PriceRepository,
) : ViewModel() {

    val solPriceUiState: MutableStateFlow<Map<String, Double>> = MutableStateFlow<Map<String, Double>>(emptyMap())

    init {
        streamSolPriceUiState()
    }

    private fun streamSolPriceUiState() {
        viewModelScope.launch {
            val price = PriceUseCase(
                priceRepository,
            ).getPriceInSol()

            solPriceUiState.emit(price)
        }

    }
}
