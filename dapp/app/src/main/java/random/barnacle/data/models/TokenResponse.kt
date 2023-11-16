package random.barnacle.data.models

import random.barnacle.domain.models.TokenModel

data class TokenResponse(
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

fun TokenResponse.mapToModel(): TokenModel {
    return TokenModel(
        address = this.address ?: "",
        decimals = this.decimals,
        logoURI = this.logoURI ?: "",
        name = this.name ?: "",
        symbol = this.symbol ?: "",
    )
}