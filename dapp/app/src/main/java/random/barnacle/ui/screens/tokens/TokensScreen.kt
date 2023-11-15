package random.barnacle.ui.screens.tokens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import random.barnacle.ui.MainMenu
import random.barnacle.ui.screens.tokens.components.PairCard
import random.barnacle.ui.view_models.PriceViewModel
import random.barnacle.ui.view_models.TokenUiState
import random.barnacle.ui.view_models.TokensViewModel

@Composable
fun TokensScreen(navController: NavHostController, tokensViewModel: TokensViewModel, priceViewModel: PriceViewModel) {
    Box(modifier = Modifier
            .fillMaxWidth()
    ) {
        MainMenu(
            navController,
        )

        when (val allTokens = tokensViewModel.allTokensUiState) {
            is TokenUiState.Success -> {
                val listOfAllTokens = allTokens.tokenResponses
                val usdcPrice = priceViewModel.usdcPriceUiState
                LazyColumn(
                    modifier = Modifier
                        .padding(
                            top = 64.dp,
                            bottom = 224.dp
                        )
                ) {
                    items(listOfAllTokens) { token ->
                        PairCard(tokenResponse = token, usdcPrice)
                    }
                }
            }
            is TokenUiState.Loading -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
            is TokenUiState.Error -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Error")
                }
            }
        }
    }
}



