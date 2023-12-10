package random.barnacle.domain.repositories

import random.barnacle.data.models.PriceResponse

interface PriceRepository {
    suspend fun fetchPricesInSol(): PriceResponse

    suspend fun fetchPricesInUsdc(): PriceResponse
}
