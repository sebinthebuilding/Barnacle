package random.barnacle.ui.screens.tokens

import QuoteCurrencyFilters
import TokenSearchBox
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import random.barnacle.ui.screens.tokens.components.PairCardsAsList
import random.barnacle.ui.view_models.PriceViewModel
import random.barnacle.ui.view_models.TokensViewModel

@Composable
fun TokensScreen(tokensViewModel: TokensViewModel, priceViewModel: PriceViewModel) {
    val allTokens = tokensViewModel.allTokensUiState
    val usdcPrices by priceViewModel.usdcPriceUiState.collectAsState(initial = emptyMap())

    var tokenSearchQuery by remember { mutableStateOf(TextFieldValue()) }

    val filteredTokens = allTokens.filter { token ->
        token.symbol.contains(tokenSearchQuery.text, ignoreCase = true)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 64.dp)
    ) {
        QuoteCurrencyFilters()
        Column(
            modifier = Modifier
                .padding(
                    top = 64.dp,
                    bottom = 160.dp)
        ) {
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
            ) {
                items(filteredTokens) { token ->
                    PairCardsAsList(token = token, usdcPrices)

                }
            }

            TokenSearchBox(
                tokenSearchQuery = tokenSearchQuery,
                onSearchQueryChange = { newQuery ->
                    tokenSearchQuery = newQuery
                },
            )
        }
    }
}