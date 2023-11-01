package random.barnacle.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

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