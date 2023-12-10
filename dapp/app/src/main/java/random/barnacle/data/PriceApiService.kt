package random.barnacle.data

import random.barnacle.data.models.PriceResponse
import random.barnacle.domain.QuoteCurrencies
import retrofit2.http.GET
import retrofit2.http.Query

interface PriceApiService {

    @GET("v4/price")
    suspend fun getPriceInUsdc(
        @Query("ids") id: String,
        @Query("vsToken") vsToken: String = QuoteCurrencies.USDC.address
    ): PriceResponse

    @GET("v4/price")
    suspend fun getPriceInSol(
        @Query("ids") id: String = "EPjFWdd5AufqSSqeM2qN1xzybapC8G4wEGGkZwyTDt1v,So11111111111111111111111111111111111111112",
        @Query("vsToken") vsToken: String = QuoteCurrencies.SOL.address
    ): PriceResponse
}

