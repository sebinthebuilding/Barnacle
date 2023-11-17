package random.barnacle.domain.use_cases

import kotlinx.coroutines.flow.StateFlow
import random.barnacle.data.models.PriceResponse
import random.barnacle.data.repositories.PriceRepository
import random.barnacle.data.repositories.TokensRepository

class PriceUseCase(private val priceRepository: PriceRepository, private val tokensRepository: TokensRepository) {

    suspend fun usdcPrice(): PriceResponse {
        val allTokens = TokensUseCase(tokensRepository).getAllTokensUseCase()
        return priceRepository.getUsdcPrice(allTokens[1].address)
    }
}