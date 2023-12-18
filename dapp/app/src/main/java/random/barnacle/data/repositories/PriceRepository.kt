package random.barnacle.data.repositories

import random.barnacle.data.PriceApiService
import javax.inject.Inject
import javax.inject.Singleton

interface PriceRepository {
    suspend fun gimmeAllPrices(
        allAddresses: String,
        selectedQuoteCurrencyAddress: String
    ): MutableMap<String, Double>
}

@Singleton
class PriceRepositoryImpl @Inject constructor(
    private val priceClient: PriceApiService,
) : PriceRepository {
    override suspend fun gimmeAllPrices(
        allAddresses: String,
        selectedQuoteCurrencyAddress: String
    )
    : MutableMap<String, Double> {
        val tokenPriceMap = mutableMapOf<String, Double>()

        val pricesResponse = priceClient.getAllPrices(
            allAddresses,
            selectedQuoteCurrencyAddress
        ).data

        val keys = pricesResponse.keys

        val values = pricesResponse.values

        for (value in values) {
            if (keys.contains(value.id)) {
                tokenPriceMap[value.id] = value.price
            }
        }

        return tokenPriceMap
    }
}