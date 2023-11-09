package random.barnacle.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import random.barnacle.AllTokensViewModel
import random.barnacle.AppUiState
import random.barnacle.nav.MainMenu

@Composable
fun TokensScreen(navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        MainMenu(navController)
        val allTokensViewModel: AllTokensViewModel = viewModel(factory = AllTokensViewModel.Factory)

        when (val allTokens = allTokensViewModel.allTokensUiState) {
            is AppUiState.Loading -> Text(text = "loading..")
            is AppUiState.Success ->  Text(allTokens.tokens)
            is AppUiState.Error -> Text(text = "Error")
        }
    }
}
