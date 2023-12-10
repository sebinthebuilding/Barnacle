package random.barnacle.domain.repositories

import random.barnacle.data.models.TokenResponse

interface TokensRepository {
    suspend fun fetchAllTokens(): List<TokenResponse>
}
