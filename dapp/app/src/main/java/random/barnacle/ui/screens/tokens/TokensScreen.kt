package random.barnacle.ui.screens.tokens

import TokenSearchBox
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import random.barnacle.domain.QuoteCurrencies
import random.barnacle.ui.screens.tokens.components.PairsList
import random.barnacle.ui.view_models.PriceViewModel
import random.barnacle.ui.view_models.TokensViewModel

@Composable
fun TokensScreen(tokensViewModel: TokensViewModel, priceViewModel: PriceViewModel) {
    val allTokens = tokensViewModel.allTokensUiState
    val usdcPrices by priceViewModel.usdcPriceUiState.collectAsState(initial = emptyMap())
    val solPrices by priceViewModel.solPriceUiState.collectAsState(initial = emptyMap())

    var tokenSearchQuery by remember { mutableStateOf(TextFieldValue()) }

    var selectedQuoteCurrency by remember { mutableStateOf<QuoteCurrencies>(QuoteCurrencies.USDC) }

    val filteredTokens = allTokens.filter { token ->
        token.symbol.contains(tokenSearchQuery.text, ignoreCase = true)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 64.dp)
    ) {
        Column {
            Row {
                OutlinedButton(
                    modifier = Modifier
                        .padding(horizontal = 8.dp, vertical = 4.dp), // Adjust padding as needed
                    contentPadding = ButtonDefaults.ContentPadding,
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
            TokenSearchBox(
                tokenSearchQuery = tokenSearchQuery,
                onSearchQueryChange = { newQuery ->
                    tokenSearchQuery = newQuery
                },
            )



                    Column(
                        modifier = Modifier
                            .padding(
                                bottom = 256.dp,
                                top = 128.dp
                            )
                    ) {
                        if (selectedQuoteCurrency == QuoteCurrencies.USDC) {
                            PairsList(filteredTokens, allTokens, usdcPrices, "USDC")
                        } else if (selectedQuoteCurrency == QuoteCurrencies.SOL) {
                            PairsList(filteredTokens, allTokens, solPrices, "SOL")
                        }
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