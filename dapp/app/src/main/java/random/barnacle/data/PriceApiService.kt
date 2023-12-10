package random.barnacle.data

import random.barnacle.data.models.PriceResponse
import random.barnacle.domain.QuoteCurrencies
import retrofit2.http.GET
import retrofit2.http.Query

interface PriceApiService {

    @GET("v4/price")
    suspend fun fetchPricesInUsdc(
        @Query("ids") id: String,
        @Query("vsToken") vsToken: String = QuoteCurrencies.USDC.address
    ): PriceResponse

    @GET("v4/price")
    suspend fun fetchPricesInSol(
        @Query("ids") id: String,
        @Query("vsToken") vsToken: String = QuoteCurrencies.SOL.address
    ): PriceResponse
}

