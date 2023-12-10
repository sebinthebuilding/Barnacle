package random.barnacle.ui.screens.tokens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import random.barnacle.domain.QuoteCurrencies
import random.barnacle.ui.screens.tokens.components.PairCardsListWithTokenSearch
import random.barnacle.ui.view_models.PriceViewModel
import random.barnacle.ui.view_models.TokensViewModel

@Composable
fun TokensScreen(
    tokensViewModel: TokensViewModel,
    priceViewModel: PriceViewModel
) {
    val allTokens = tokensViewModel.allTokensUiState
    val prices by priceViewModel.ANYPriceUiState.collectAsState(initial = emptyMap())

    var selectedQuoteCurrency by remember { mutableStateOf<QuoteCurrencies>(QuoteCurrencies.USDC) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 64.dp)
    ) {
        Column {
            Row {
                OutlinedButton(
                    onClick = { selectedQuoteCurrency = QuoteCurrencies.USDC }
                ) {
                    Text(text = "USDC")
                }

                OutlinedButton(
                    onClick = { selectedQuoteCurrency = QuoteCurrencies.SOL }
                ) {
                    Text(text = "SOL")
                }
            }
            Column(
                modifier = Modifier
                    .padding(bottom = 192.dp),
            ) {
                PairCardsListWithTokenSearch(allTokens, prices, QuoteCurrencies.USDC.name)
            }

        }
    }


}

/*
    if (selectedPairCard != null) {
        selectedPairCard?.let { token ->
            val price = prices[token.address] ?: 0.0

            PairDetailsAndComposableTokenSwap(token = token, price = price, allTokens = allTokens)
        }
    } else {

    }
 */