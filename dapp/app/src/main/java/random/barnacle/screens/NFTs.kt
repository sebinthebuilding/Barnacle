package random.barnacle.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import random.barnacle.nav.MainMenu
import random.barnacle.theme.BarnacleTheme

@Composable
fun NFTsScreen(navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        MainMenu(navController)
        Text(text = "nfts")
    }
}
