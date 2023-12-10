package random.barnacle.domain.use_cases

import random.barnacle.data.models.mapToModel
import random.barnacle.domain.models.TokenModel
import random.barnacle.domain.repositories.TokensRepository
import javax.inject.Inject

class TokensUseCase @Inject constructor(
    private val tokensRepository: TokensRepository
) {
    var cachedTokens: List<TokenModel> = emptyList()

    suspend fun getAllTokensUseCase(): List<TokenModel> {
        val tokens = tokensRepository.getAllTokens().map { it.mapToModel() }

        cachedTokens = tokens

        return tokens
    }
}