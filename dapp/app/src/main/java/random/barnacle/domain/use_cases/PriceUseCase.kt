package random.barnacle.domain.use_cases

import android.util.Log
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import random.barnacle.data.repositories.PriceRepository
import random.barnacle.data.repositories.TokensRepository

class PriceUseCase(private val priceRepository: PriceRepository, private val tokensRepository: TokensRepository) {

    suspend fun getUsdcPrice(): Map<String, Double> = coroutineScope {
        val tokens = TokensUseCase(tokensRepository).getAllTokensUseCase()
        val tokenPriceMap = mutableMapOf<String, Double>()

        val priceDeferredList: List<Deferred<Double>> = tokens.map { token ->
            async {
                val prices = priceRepository.getUsdcPrice(token.address)
                val price = prices.data[token.address]?.price ?: 0.0
                Log.d("PRICES_BOI", prices.toString())
                price
            }
        }

        val pricesList: List<Double> = priceDeferredList.awaitAll()

        tokens.forEachIndexed { index, token ->
            pricesList[index].let { price ->
                tokenPriceMap[token.address] = price
            }
        }

                Log.d("MAP_BOODGE", tokenPriceMap.toString())

        return@coroutineScope tokenPriceMap
    }

    suspend fun getSolPrice(): Map<String, Double> = coroutineScope {
        val tokens = TokensUseCase(tokensRepository).getAllTokensUseCase()
        val tokenPriceMap = mutableMapOf<String, Double>()

        val priceDeferredList: List<Deferred<Double>> = tokens.map { token ->
            async {
                val prices = priceRepository.getSolPrice(token.address)
                val price = prices.data[token.address]?.price ?: 0.0
                Log.d("SOL_PRICES_BOI", prices.toString())
                price
            }
        }

        val pricesList: List<Double> = priceDeferredList.awaitAll()

        tokens.forEachIndexed { index, token ->
            pricesList[index].let { price ->
                tokenPriceMap[token.address] = price
            }
        }

        Log.d("SOL_MAP_BOODGE", tokenPriceMap.toString())

        return@coroutineScope tokenPriceMap
    }
}