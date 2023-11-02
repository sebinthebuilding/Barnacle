package random.barnacle.network

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