package random.barnacle.data

import random.barnacle.data.models.PriceResponse
import random.barnacle.data.models.TokenResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TokenApiService {
    @GET("all")
    suspend fun getAllTokens(): List<TokenResponse>

}