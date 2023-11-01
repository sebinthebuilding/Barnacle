package random.barnacle.network


import retrofit2.http.GET

interface BarnacleApiService {
    @GET("all")
    suspend fun getAllTokens(): String

    @GET("v4/price?ids=7vfCXTUXx5WJV5JADk17DUJ4ksgau7utNKj4b963voxs&vsToken=So11111111111111111111111111111111111111112")
    suspend fun getEthSolPrice(): String
}