package random.barnacle.data

import random.barnacle.data.models.PriceResponse
import random.barnacle.data.models.TokenResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface AppApiService {
    @GET("all")
    suspend fun getAllTokens(): List<TokenResponse>

    @GET("strict")
    suspend fun getStrictTokens(): List<TokenResponse>

    @GET("v4/price")
    suspend fun getUsdcPrice(@Query("ids") id: String): PriceResponse

    @GET("v4/price")
    suspend fun getSolPrice(@Query("ids") id: String, @Query("vsToken") vsToken: String): PriceResponse

}