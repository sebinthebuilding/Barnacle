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
        val response = tokenClient.getAllTokens()
        if (response.isSuccessful) {
            val responseBody = response.body()
            if (responseBody != null) {
                return responseBody.map { it.mapToModel() }
            } else {
                throw IllegalStateException("Failed to fetch tokens: ${response.code()}")
            }
        } else {
            throw IllegalStateException("Failed to fetch tokens: ${response.code()}")
        }
    }
}

