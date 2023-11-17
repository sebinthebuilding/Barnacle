package random.barnacle.domain.models

class TokenModel(
    var address: String,
    val decimals: Int,
    val logoURI: String,
    val name: String,
    val symbol: String
)