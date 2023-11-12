package random.barnacle.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import random.barnacle.TokensViewModel
import random.barnacle.AppUiState
import random.barnacle.nav.MainMenu

@Composable
fun TokensScreen(navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        MainMenu(navController)
        val tokensViewModel: TokensViewModel = viewModel(factory = TokensViewModel.Factory)

        Column {
            when (val allTokens = tokensViewModel.allTokensUiState) {
                is AppUiState.Loading -> Text(text = "loading..")
                is AppUiState.Success -> Text(text = allTokens.count)
                is AppUiState.Error -> Text(text = "Error")
            }

            when (val strictTokens = tokensViewModel.strictTokensUiState) {
                is AppUiState.Loading -> Text(text = "loading..")
                is AppUiState.Success -> Text(text = strictTokens.count)
                is AppUiState.Error -> Text(text = "Error")
            }
        }
    }
}
