package random.barnacle.domain.use_cases

import android.util.Log
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import random.barnacle.data.models.PriceData
import random.barnacle.domain.QuoteCurrencies
import random.barnacle.domain.repositories.PriceRepository
import random.barnacle.domain.repositories.TokensRepository
import javax.inject.Inject


class PriceUseCase @Inject constructor(
    private val priceRepository: PriceRepository,
    private val tokensRepository: TokensRepository
) {
    suspend fun getANYPrice(): Map<String, Double> {

        val response = priceRepository.getANYPrice().data.entries
        Log.d("PRICE_RESPONSE", response.toString())

        val tokenPriceMap = mutableMapOf<String, Double>()

        val usdc_price = priceRepository.getANYPrice().data[QuoteCurrencies.USDC.address]?.price ?: 0.0

        Log.d("USDC_PRICE_IN_SOL", usdc_price.toString())

        tokenPriceMap[QuoteCurrencies.USDC.address] = usdc_price

        val sol_price = priceRepository.getANYPrice().data[QuoteCurrencies.SOL.address]?.price ?: 0.0

        Log.d("SOL_PRICE_IN_SOL", sol_price.toString())


        return tokenPriceMap
    }
}