package random.barnacle.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import random.barnacle.BarnacleViewModel
import random.barnacle.nav.MainMenu

@Composable
fun TokensScreen(navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        MainMenu(navController)
        Text(text = "tokes")
        val barnacleViewModel: BarnacleViewModel = viewModel()
        Text(text = barnacleViewModel.barnacleUiState)
    }
}
