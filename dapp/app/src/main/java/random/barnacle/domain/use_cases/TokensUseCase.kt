package random.barnacle.domain.use_cases

import random.barnacle.data.models.mapToModel
import random.barnacle.domain.models.TokenModel
import random.barnacle.domain.repositories.TokensRepository

class TokensUseCase(private val tokensRepository: TokensRepository) {

    suspend fun getAllTokensUseCase(): List<TokenModel> {
        return tokensRepository.getAllTokens().map { it.mapToModel() }
    }
}