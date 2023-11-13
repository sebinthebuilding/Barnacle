package random.barnacle.data

import kotlinx.coroutines.flow.Flow
import random.barnacle.data.models.PriceResponse
import random.barnacle.network.AppApiService

interface PriceRepository {
    suspend fun getUsdcPrice(splTokenAdress: String): PriceResponse
}

class NetworkPriceRepository(private val priceClient: AppApiService) : PriceRepository {
    override suspend fun getUsdcPrice(splTokenAdress: String): PriceResponse {
        return priceClient.getUsdcPrice(splTokenAdress)
    }
}