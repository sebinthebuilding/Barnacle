package random.barnacle.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import random.barnacle.screens.AnalyticsScreen
import random.barnacle.screens.EarnScreen
import random.barnacle.screens.FavoritesScreen
import random.barnacle.screens.NFTsScreen
import random.barnacle.screens.TokensScreen
import random.barnacle.screens.WalletScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.WALLET) {

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

        composable(Routes.WALLET) {
            WalletScreen(navController)
        }

        composable(Routes.ANALYTICS) {
            AnalyticsScreen(navController)
        }

    }
}

