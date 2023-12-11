package random.barnacle.domain.repositories

import random.barnacle.data.models.PriceResponse

interface PriceRepository {
    suspend fun fetchAllPrices(selectedQuoteCurrencyAddress: String): PriceResponse
}
