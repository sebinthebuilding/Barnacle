package random.barnacle.domain.use_cases

import random.barnacle.data.models.mapToModel
import random.barnacle.data.repositories.TokensRepository
import random.barnacle.domain.models.TokenModel

class TokensUseCase(private val tokensRepository: TokensRepository) {

    suspend fun getAllTokensUseCase(): List<TokenModel> {
        return tokensRepository.getAllTokens().map { it.mapToModel() }
    }

    suspend fun getStrictTokensUseCase(): List<TokenModel> {
        return tokensRepository.getStrictTokens().map { it.mapToModel() }
    }
}