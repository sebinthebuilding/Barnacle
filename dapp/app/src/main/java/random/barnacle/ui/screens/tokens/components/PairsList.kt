package random.barnacle.ui.screens.tokens.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import random.barnacle.domain.models.TokenModel

@Composable
fun PairsList(allTokens: List<TokenModel>, filteredTokens: List<TokenModel>, prices: Map<String, Double>, quoteCurrency: String) {
    LazyColumn(
    ){
        items(filteredTokens) { token ->
            val price = prices[token.address] ?: 0.0
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                    //.clickable { selectedPairCard = token },
                shape = RoundedCornerShape(12.dp)
            ) {
                PairCardContents(token = token, price = price, quoteCurrency = quoteCurrency)
            }
        }
    }
}
