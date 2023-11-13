package random.barnacle.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import random.barnacle.ui.screens.AnalyticsScreen
import random.barnacle.ui.screens.EarnScreen
import random.barnacle.ui.screens.FavoritesScreen
import random.barnacle.ui.screens.NFTsScreen
import random.barnacle.ui.screens.tokens.TokensScreen
import random.barnacle.ui.screens.WalletScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.HOLDINGS) {

        composable(Routes.FAVORITES) {
            FavoritesScreen(navController)
        }

        composable(Routes.TOKENS) {
            TokensScreen(navController)
        }

        composable(Routes.NFTs) {
            NFTsScreen(navController)
        }

        composable(Routes.EARN) {
            EarnScreen(navController)
        }

        composable(Routes.HOLDINGS) {
            WalletScreen(navController)
        }

        composable(Routes.ANALYTICS) {
            AnalyticsScreen(navController)
        }

    }
}

