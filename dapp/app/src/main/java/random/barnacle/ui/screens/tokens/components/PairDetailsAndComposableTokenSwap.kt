
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import random.barnacle.domain.QuoteCurrencies
import random.barnacle.domain.models.TokenModel

@Composable
fun PairDetailsAndComposableTokenSwap(
    prices: Map<String, Double>,
    token: TokenModel,
    quoteCurrency: String,
    allTokens: List<TokenModel>
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = token.symbol + "1 $quoteCurrency",
            modifier = Modifier.padding(16.dp)
        )
    }
}