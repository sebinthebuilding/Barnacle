package random.barnacle.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

        var listOfAllTokens: List<Token> = emptyList()

        when (val allTokens = tokensViewModel.allTokensUiState) {
            is TokenUiState.Success -> listOfAllTokens = allTokens.tokens
            is TokenUiState.Loading -> Text(text = "Please Wait")
            is TokenUiState.Error -> Text(text = "Error")
        }
        val usdcObject: Token? = listOfAllTokens.find { it.address == "EPjFWdd5AufqSSqeM2qN1xzybapC8G4wEGGkZwyTDt1v" }

        if (usdcObject != null) {
            Text(text = usdcObject.toString())
        }

    }
}
