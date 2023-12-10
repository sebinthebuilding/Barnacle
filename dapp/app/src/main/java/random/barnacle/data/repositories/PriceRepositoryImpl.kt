package random.barnacle.data.repositories

import random.barnacle.data.PriceApiService
import random.barnacle.data.models.PriceResponse
import random.barnacle.domain.repositories.PriceRepository
import random.barnacle.domain.use_cases.TokensUseCase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PriceRepositoryImpl @Inject constructor(
    private val priceClient: PriceApiService,
) : PriceRepository {
    override suspend fun getPriceInSol(): PriceResponse {
        return priceClient.getPriceInSol()
    }
}