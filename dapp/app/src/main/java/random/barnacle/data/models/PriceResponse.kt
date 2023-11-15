package random.barnacle.data.models
data class PriceResponse(
    val data: Map<String, PriceData>,
    val timeTaken: Double
)

data class PriceData(
    val id: String,
    val mintSymbol: String,
    val price: Double,
    val vsToken: String,
    val vsTokenSymbol: String
)