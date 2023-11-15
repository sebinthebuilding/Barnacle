package random.barnacle.ui.screens.tokens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import random.barnacle.ui.MainMenu
import random.barnacle.ui.screens.tokens.components.PairCard
import random.barnacle.ui.view_models.PriceViewModel
import random.barnacle.ui.view_models.TokensViewModel

@Composable
fun TokensScreen(navController: NavHostController, tokensViewModel: TokensViewModel, priceViewModel: PriceViewModel) {
    Box(modifier = Modifier
            .fillMaxWidth()
    ) {
        MainMenu(
            navController,
        )
        val listOfAllTokens = tokensViewModel.allTokensUiState
        val usdcPrice = priceViewModel.usdcPriceUiState

        LazyColumn(
            modifier = Modifier
                .padding(
                    top = 64.dp,
                    bottom = 224.dp
                )
        ) {
            this.items(listOfAllTokens) { token ->
                PairCard(token = token, usdcPrice)
            }
        }
    }
}



