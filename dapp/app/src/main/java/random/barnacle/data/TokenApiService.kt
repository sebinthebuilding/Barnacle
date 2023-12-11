package random.barnacle.data

import random.barnacle.data.models.TokenResponse
import retrofit2.http.GET

interface TokenApiService {
    @GET("all")
    suspend fun getAllTokens(): List<TokenResponse>

}