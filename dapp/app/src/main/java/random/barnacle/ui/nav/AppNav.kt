import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import random.barnacle.ui.nav.MainMenu
import random.barnacle.ui.screens.AnalyticsScreen
import random.barnacle.ui.screens.WalletScreen
import random.barnacle.ui.screens.tokens.TokensScreen
import random.barnacle.ui.view_models.PriceViewModel
import random.barnacle.ui.view_models.TokensViewModel

@Composable
fun AppNav() {
    val navController = rememberNavController()

    MainMenu(navController = navController)

    val tokensViewModel: TokensViewModel = viewModel(factory = TokensViewModel.Factory)

    val priceViewModel: PriceViewModel = viewModel(factory = PriceViewModel.Factory)

    NavHost(navController = navController, startDestination = ) {
        composable(Routes.TOKENS) {
            TokensScreen(tokensViewModel, priceViewModel)
        }

        composable() {
            WalletScreen(navController)
        }

        composable(Routes.ANALYTICS) {
            AnalyticsScreen(navController)
        }
    }
}

