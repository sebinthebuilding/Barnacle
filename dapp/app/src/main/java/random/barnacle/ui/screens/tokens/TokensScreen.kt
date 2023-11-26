package random.barnacle.ui.screens.tokens

import PairDetailsAndComposableTokenSwap
import QuoteCurrencyFilters
import TokenSearchBox
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import random.barnacle.domain.QuoteCurrencies
import random.barnacle.domain.models.TokenModel
import random.barnacle.ui.screens.tokens.components.PairCardContents
import random.barnacle.ui.view_models.PriceViewModel
import random.barnacle.ui.view_models.TokensViewModel

@Composable
fun TokensScreen(tokensViewModel: TokensViewModel, priceViewModel: PriceViewModel) {
    val allTokens = tokensViewModel.allTokensUiState
    val usdcPrices by priceViewModel.usdcPriceUiState.collectAsState(initial = emptyMap())

    var tokenSearchQuery by remember { mutableStateOf(TextFieldValue()) }

    var selectedPairCard by remember { mutableStateOf<TokenModel?>(null) }

    var selectedQuoteCurrency by remember { mutableStateOf<QuoteCurrencies>(QuoteCurrencies.USDC) }

    val filteredTokens = allTokens.filter { token ->
        token.symbol.contains(tokenSearchQuery.text, ignoreCase = true)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 64.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(
                    top = 64.dp,
                    bottom = 160.dp)
        ) {
            if (selectedPairCard != null) {
                selectedPairCard?.let { token ->
                    val usdcPrice = usdcPrices[token.address] ?: 0.0

                    PairDetailsAndComposableTokenSwap(token = token, usdcPrice = usdcPrice, allTokens = allTokens)
                }
            } else {

                QuoteCurrencyFilters()

                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    items(filteredTokens) { token ->
                        val usdcPrice = usdcPrices[token.address] ?: 0.0
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 8.dp)
                                .clickable {
                                    selectedPairCard = token
                                },
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            PairCardContents(token = token, usdcPrice = usdcPrice)
                        }
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
}