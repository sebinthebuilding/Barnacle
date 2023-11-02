package random.barnacle.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val JUP_AG_PRICE = "https://price.jup.ag"

private val retrofitJupAgPrice = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(JUP_AG_PRICE)
    .build()
