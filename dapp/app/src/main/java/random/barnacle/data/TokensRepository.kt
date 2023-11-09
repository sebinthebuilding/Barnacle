package random.barnacle.data

import random.barnacle.network.AppApiService
import random.barnacle.network.Token

interface TokensRepository {
    suspend fun getAllTokens(): List<Token>
    //suspend fun getStrictTokens(): List<Token>
}

class NetworkTokensRepository(private val client: AppApiService) : TokensRepository {
    override suspend fun getAllTokens(): List<Token> {
        return client.getAllTokens()
    }
    /*
    override suspend fun getStrictTokens(): List<Token> {
        return
    }
    */
}