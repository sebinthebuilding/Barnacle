package random.barnacle.data

import random.barnacle.network.AppApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val allTokensRepository: TokensRepository
}

class DefaultAppContainer : AppContainer {
    private val urlJupAgTokens = "https://token.jup.ag"

    private val retrofitJupAgTokens = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(urlJupAgTokens)
        .build()

    private val client : AppApiService by lazy {
        retrofitJupAgTokens.create(AppApiService::class.java)
    }

    override val allTokensRepository: TokensRepository by lazy {
        NetworkTokensRepository(client)
    }
}