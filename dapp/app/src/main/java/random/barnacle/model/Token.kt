package random.barnacle.model

data class Token(
    val address: String,
    val chainId: Int,
    val decimals: Int,
    val extensions: Extensions,
    val logoURI: String,
    val name: String,
    val symbol: String,
    val tags: List<String>
)

data class Extensions(
    val coingeckoId: String,
    val isBanned: Boolean
)