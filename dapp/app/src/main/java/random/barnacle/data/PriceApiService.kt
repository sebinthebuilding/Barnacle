package random.barnacle.data

import random.barnacle.data.models.PriceResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PriceApiService {

    @GET("v4/price")
    suspend fun getAllPrices(
        @Query("ids") id: String,
        @Query("vsToken") vsToken: String,
    ): PriceResponse
}

