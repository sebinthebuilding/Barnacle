package random.barnacle.data

import random.barnacle.data.models.PriceResponse
import random.barnacle.domain.QuoteCurrencies
import retrofit2.http.GET
import retrofit2.http.Query

interface PriceApiService {

    @GET("v4/price")
    suspend fun getUsdcPrice(
        @Query("ids") id: String = testingStrings.strings,
        @Query("vsToken") vsToken: String = QuoteCurrencies.USDC.address
    ): PriceResponse

    @GET("v4/price")
    suspend fun getSolPrice(
        @Query("ids") id: String = testingStrings.strings,
        @Query("vsToken") vsToken: String = QuoteCurrencies.SOL.address
    ): PriceResponse
}

object testingStrings {
    val strings = listOf(QuoteCurrencies.USDC.address, QuoteCurrencies.SOL.address)
        .joinToString(",")
}