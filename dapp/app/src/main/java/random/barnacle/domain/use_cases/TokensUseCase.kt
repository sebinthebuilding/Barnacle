package random.barnacle.domain.use_cases

import android.util.Log
import random.barnacle.data.models.mapToModel
import random.barnacle.domain.models.TokenModel
import random.barnacle.domain.repositories.TokensRepository
import javax.inject.Inject

class TokensUseCase @Inject constructor(
    private val tokensRepository: TokensRepository
) {
    suspend fun getAllTokensUseCase(): List<TokenModel> {
        val tokens = tokensRepository.fetchAllTokens().map { it.mapToModel() }

        val tokenAddresses = tokens.joinToString(",") { it.address }

        Log.d("ADDRESSES", tokenAddresses)

        return tokens
    }
}