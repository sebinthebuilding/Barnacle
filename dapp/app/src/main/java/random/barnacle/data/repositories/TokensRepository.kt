package random.barnacle.data.repositories

import random.barnacle.data.TokenApiService
import random.barnacle.data.models.mapToModel
import random.barnacle.domain.models.TokenModel
import javax.inject.Inject
import javax.inject.Singleton

interface TokensRepository {
    suspend fun gimmeAllTokens(): List<TokenModel>
}

@Singleton
class TokensRepositoryImpl @Inject constructor(
    private val tokenClient: TokenApiService
) : TokensRepository {
    override suspend fun gimmeAllTokens(): List<TokenModel> {
        return tokenClient.getAllTokens().map { it.mapToModel() }
    }
}
