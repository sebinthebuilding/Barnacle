package random.barnacle

import random.barnacle.data.NetworkPriceRepository
import random.barnacle.data.NetworkTokensRepository
import random.barnacle.data.PriceRepository
import random.barnacle.data.TokensRepository
import random.barnacle.network.AppApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val tokensRepository: TokensRepository
    val priceRepository: PriceRepository
}

class DefaultAppContainer : AppContainer {
    private val urlJupAgTokens = "https://token.jup.ag/"

    private val retrofitJupAgTokens = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(urlJupAgTokens)
        .build()
    private val retrofitJupAgPrice = Retrofit.Builder()
        .addConverterFactory((GsonConverterFactory.create()))
        .baseUrl("https://price.jup.ag/")
        .build()

    private val tokenClient : AppApiService by lazy {
        retrofitJupAgTokens.create(AppApiService::class.java)
    }

    private val priceClient : AppApiService by lazy {
        retrofitJupAgPrice.create(AppApiService::class.java)
    }

    override val tokensRepository: TokensRepository by lazy {
        NetworkTokensRepository(tokenClient)
    }

    override val priceRepository: PriceRepository by lazy {
        NetworkPriceRepository(priceClient)
    }
}