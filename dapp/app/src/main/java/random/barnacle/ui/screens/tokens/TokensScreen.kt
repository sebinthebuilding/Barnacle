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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import random.barnacle.ui.MainMenu
import random.barnacle.ui.screens.tokens.components.PairCard
import random.barnacle.ui.view_models.TokenUiState
import random.barnacle.ui.view_models.TokensViewModel

@Composable
fun TokensScreen(navController: NavHostController) {
    Box(modifier = Modifier
            .fillMaxWidth()
    ) {
        MainMenu(
            navController,
        )
    }
    val tokensViewModel: TokensViewModel = viewModel(factory = TokensViewModel.Factory)

    when (val allTokens = tokensViewModel.allTokensUiState) {
        is TokenUiState.Success -> {
            val listOfAllTokens = allTokens.tokens
            LazyColumn(
                modifier = Modifier
                    .padding(
                        top = 64.dp,
                        bottom = 224.dp
                    )
            ) {
                items(listOfAllTokens) { token ->
                    PairCard(token = token)
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



