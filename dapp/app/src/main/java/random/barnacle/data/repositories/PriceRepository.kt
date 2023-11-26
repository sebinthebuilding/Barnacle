package random.barnacle.data.repositories

import random.barnacle.data.AppApiService
import random.barnacle.data.models.PriceResponse

interface PriceRepository {
    suspend fun getUsdcPrice(splTokenAddress: String): PriceResponse
    suspend fun getSolPrice(splTokenAddress: String): PriceResponse
}

class NetworkPriceRepository(private val priceClient: AppApiService) : PriceRepository {
    override suspend fun getUsdcPrice(splTokenAdress: String): PriceResponse {
        return priceClient.getUsdcPrice(splTokenAdress)
    }

    override suspend fun getSolPrice(splTokenAddress: String): PriceResponse {
        return priceClient.getSolPrice(splTokenAddress, "So11111111111111111111111111111111111111112")
    }
}