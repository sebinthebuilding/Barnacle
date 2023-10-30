package random.barnacle.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val JUP_AG_TOKENS = "https://token.jup.ag"

private val retrofitJupAgTokens = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(JUP_AG_TOKENS)
    .build()

object JupAgTokensApi {
    val client : BarnacleApiService by lazy {
        retrofitJupAgTokens.create(BarnacleApiService::class.java)
    }
}

private const val JUP_AG_PRICE = "https://price.jup.ag"

private val retrofitJupAgPrice = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(JUP_AG_PRICE)
    .build()
object JupAgPriceApi {
    val client : BarnacleApiService by lazy {
        retrofitJupAgPrice.create(BarnacleApiService::class.java)
    }

}
interface BarnacleApiService {
    @GET("all")
    suspend fun getAllTokens(): String

    @GET("v4/price?ids=7vfCXTUXx5WJV5JADk17DUJ4ksgau7utNKj4b963voxs&vsToken=So11111111111111111111111111111111111111112")
    suspend fun getEthSolPrice(): String
}