package random.barnacle.domain.use_cases

import android.util.Log
import random.barnacle.domain.QuoteCurrencies
import random.barnacle.domain.repositories.PriceRepository
import javax.inject.Inject


class PriceUseCase @Inject constructor(
    private val priceRepository: PriceRepository,
) {
    suspend fun getPriceInSol(): Map<String, Double> {
        val tokenPriceMap = mutableMapOf<String, Double>()

        val pricesResponse = priceRepository.getPriceInSol().data

        Log.d("PRICE_RESPONSES", pricesResponse.toString())

        val keys = pricesResponse.keys

        val values = pricesResponse.values

        Log.d("PRICE_KEYS", keys.toString())
        Log.d("PRICE_VALUES", values.toString())

        for (value in values) {
            if (keys.contains(value.id)) {
                tokenPriceMap[value.id] = value.price
            }
        }

        Log.d("TOKEN_PRICE_MAP_IN_SOL", tokenPriceMap.toString())

        return tokenPriceMap
    }
}