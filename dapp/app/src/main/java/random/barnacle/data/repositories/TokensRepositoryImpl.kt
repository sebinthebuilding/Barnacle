package random.barnacle.data.repositories

import random.barnacle.data.TokenApiService
import random.barnacle.data.models.TokenResponse
import random.barnacle.domain.repositories.TokensRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TokensRepositoryImpl @Inject constructor(
    private val tokenClient: TokenApiService
) : TokensRepository {
    override suspend fun getAllTokens(): List<TokenResponse> {
        return tokenClient.getAllTokens()
    }
}
