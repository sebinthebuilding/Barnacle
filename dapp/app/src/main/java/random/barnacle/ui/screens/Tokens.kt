package random.barnacle.ui.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import random.barnacle.TokensViewModel
import random.barnacle.TokenUiState
import random.barnacle.model.Token
import random.barnacle.nav.MainMenu

@Composable
fun TokensScreen(navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        MainMenu(navController)
        val tokensViewModel: TokensViewModel = viewModel(factory = TokensViewModel.Factory)

        when (val allTokens = tokensViewModel.allTokensUiState) {
            is TokenUiState.Success -> {
                val listOfAllTokens = allTokens.tokens
                LazyColumn {
                    this.items(listOfAllTokens) { token ->
                        PairCard(token = token)

                    }
                }
            }
            is TokenUiState.Loading -> Text(text = "loading..")
            is TokenUiState.Error -> Text(text = "Error")
        }
    }
}

@Composable
fun PairCard(token: Token, modifier: Modifier = Modifier) {
    Row {
        Text(text = "1 ${token.symbol}   X USDC")
    }
}
