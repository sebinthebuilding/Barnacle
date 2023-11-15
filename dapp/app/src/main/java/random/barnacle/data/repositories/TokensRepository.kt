package random.barnacle.data.repositories

import random.barnacle.data.models.TokenResponse
import random.barnacle.data.AppApiService

interface TokensRepository {
    suspend fun getAllTokens(): List<TokenResponse>
    suspend fun getStrictTokens(): List<TokenResponse>
}

class NetworkTokensRepository(private val tokenClient: AppApiService) : TokensRepository {
    override suspend fun getAllTokens(): List<TokenResponse> {
        return tokenClient.getAllTokens()
    }

    override suspend fun getStrictTokens(): List<TokenResponse> {
        return tokenClient.getStrictTokens()
    }
}
