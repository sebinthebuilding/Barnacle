package random.barnacle.data.repositories

import random.barnacle.data.AppApiService
import random.barnacle.data.models.PriceResponse

interface PriceRepository {
    suspend fun getUsdcPrice(splTokenAdresses: String): PriceResponse
}

class NetworkPriceRepository(private val priceClient: AppApiService) : PriceRepository {
    override suspend fun getUsdcPrice(splTokenAdresses: String): PriceResponse {
        return priceClient.getUsdcPrice(splTokenAdresses)
    }
}