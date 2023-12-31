package random.barnacle.ui.screens.wallet

import MainMenu
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun WalletScreen(
    navController: NavHostController,
    fakeState: String
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        MainMenu(navController = navController)
        Text(text = fakeState)
    }
}
