package random.barnacle.ui.screens.tokens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import random.barnacle.ui.nav.MainMenu
import random.barnacle.ui.screens.tokens.components.PairCards
import random.barnacle.ui.screens.tokens.components.QuoteCurrencyFilters
import random.barnacle.ui.screens.tokens.components.TokenSearchBox
import random.barnacle.ui.view_models.PriceViewModel
import random.barnacle.ui.view_models.TokensViewModel

@Composable
fun TokensScreen(navController: NavHostController, tokensViewModel: TokensViewModel, priceViewModel: PriceViewModel) {

    val allTokens = tokensViewModel.allTokensUiState
    val usdcPrices by priceViewModel.usdcPriceUiState.collectAsState(initial = emptyMap())

    Box(modifier = Modifier
        .fillMaxWidth()
    ) {
        MainMenu(
            navController,
        )

        QuoteCurrencyFilters()

        TokenSearchBox()
        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                modifier = Modifier
                    .padding(
                        top = 64.dp,
                        bottom = 224.dp
                    )
            ) {
                items(allTokens) { token ->
                    PairCards(token = token, usdcPrices)
                }
            }
        }
    }
}