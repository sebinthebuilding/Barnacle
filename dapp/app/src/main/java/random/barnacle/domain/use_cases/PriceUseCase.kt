package random.barnacle.domain.use_cases

import android.util.Log
import random.barnacle.data.repositories.PriceRepository
import random.barnacle.data.repositories.TokensRepository

class PriceUseCase(private val priceRepository: PriceRepository, private val tokensRepository: TokensRepository) {

    suspend fun getPrice(): Map<String, Double> {
        val tokens = TokensUseCase(tokensRepository).getAllTokensUseCase()
        val tokenPriceMap = mutableMapOf<String, Double>()

        tokens.forEach { token ->
            val prices = priceRepository.getUsdcPrice(token.address)
            prices.data[token.address]?.price?.let { price ->
                tokenPriceMap[token.address] = price
            }

            Log.d("PRICES_BOI", prices.toString())
        }

        Log.d("MAP_BOODGE", tokenPriceMap.toString())

        return tokenPriceMap
    }
}