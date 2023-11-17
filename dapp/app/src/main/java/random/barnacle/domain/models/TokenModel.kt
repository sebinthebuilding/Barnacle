package random.barnacle.domain.models

import random.barnacle.data.repositories.PriceRepository
import random.barnacle.data.repositories.TokensRepository
import random.barnacle.domain.use_cases.PriceUseCase

class TokenModel(
    var address: String,
    val decimals: Int,
    val logoURI: String,
    val name: String,
    val symbol: String
)