package random.barnacle.network

import retrofit2.http.GET

interface BarnacleApiService {
    @GET("all")
    suspend fun getAllTokens(): List<Token>

}