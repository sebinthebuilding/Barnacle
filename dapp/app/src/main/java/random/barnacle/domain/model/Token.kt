package random.barnacle.domain.model

data class Token(
    var address: String,
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