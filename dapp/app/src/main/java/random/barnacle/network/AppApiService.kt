package random.barnacle.network

import retrofit2.http.GET

interface AppApiService {
    @GET("all")
    suspend fun getAllTokens(): List<Token>

    @GET("strict")
    suspend fun getStrictTokens(): List<Token>
}