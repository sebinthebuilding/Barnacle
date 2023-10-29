package random.barnacle.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val JUP_AG_TOKENS = "https://token.jup.ag"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(JUP_AG_TOKENS)
    .build()

object BarnacleApi {
    val retrofitService : BarnacleApiService by lazy {
        retrofit.create(BarnacleApiService::class.java)
    }
}
interface BarnacleApiService {
    @GET("all")
    suspend fun getAllTokens(): String
}