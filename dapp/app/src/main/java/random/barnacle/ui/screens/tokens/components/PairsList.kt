package random.barnacle.ui.screens.tokens.components

import PairDetailsAndComposableTokenSwap
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import random.barnacle.domain.models.TokenModel

@Composable
fun PairsList(
    allTokens: List<TokenModel>,
    filteredTokens: List<TokenModel>,
    prices: Map<String, Double>,
    quoteCurrency: String
) {
    var selectedPairCard by remember { mutableStateOf<TokenModel?>(null) }

    var price by remember { mutableDoubleStateOf(0.0) }

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "List of Pair Cards") {

        composable("List of Pair Cards") {
            LazyColumn {
                items(filteredTokens) { token ->
                    price = prices[token.address] ?: 0.0
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                            .clickable {
                                selectedPairCard = token
                                navController.navigate("Pair Details")
                            },
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        PairCardContents(token = token, price = price, quoteCurrency = quoteCurrency)
                    }
                }
            }
        }

        composable("Pair Details") {
            selectedPairCard?.let { token -> PairDetailsAndComposableTokenSwap(token = token, price = price, allTokens = allTokens) }
        }

    }

}
