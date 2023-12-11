import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import random.barnacle.domain.models.TokenModel

@Composable
fun PairDetailsAndComposableTokenSwap(
    allPrices: Map<String, Double>,
    token: TokenModel,
    quoteCurrency: String,
    allTokens: List<TokenModel>
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Price graph or visualization goes here
        // Replace this with your price graph composable

        Spacer(modifier = Modifier.height(16.dp))

        // Text displaying the current price
        Text(
            text = "${allPrices[token.address] ?: 0.0} ${token.symbol} / 1 $quoteCurrency",
            modifier = Modifier.padding(16.dp)
        )
    }
}
