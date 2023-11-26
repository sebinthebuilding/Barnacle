
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import random.barnacle.domain.models.TokenModel

@Composable
fun PairDetailsAndComposableTokenSwap(token: TokenModel, usdcPrice: Double, allTokens: List<TokenModel>) {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = usdcPrice.toString() + " USDC / " + token.symbol,
            modifier = Modifier.padding(16.dp)
        )
    }
}