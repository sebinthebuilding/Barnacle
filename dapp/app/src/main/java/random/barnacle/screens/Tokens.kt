package random.barnacle.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import random.barnacle.AllTokensViewModel
import random.barnacle.nav.MainMenu

@Composable
fun TokensScreen(navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        MainMenu(navController)
        val allTokensViewModel: AllTokensViewModel = viewModel()
        val noOfTokes = allTokensViewModel.allTokensUiState.size
        Text(text = "$noOfTokes")
    }
}
