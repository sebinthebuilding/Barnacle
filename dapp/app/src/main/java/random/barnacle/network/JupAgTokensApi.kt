package random.barnacle.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

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
