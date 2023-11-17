package random.barnacle.data.repositories

import android.util.Log
import random.barnacle.data.models.PriceResponse
import random.barnacle.data.AppApiService

interface PriceRepository {
    suspend fun getUsdcPrice(splTokenAdresses: String): PriceResponse
}

class NetworkPriceRepository(private val priceClient: AppApiService) : PriceRepository {
    override suspend fun getUsdcPrice(splTokenAdresses: String): PriceResponse {
        return priceClient.getUsdcPrice(splTokenAdresses)
    }
}