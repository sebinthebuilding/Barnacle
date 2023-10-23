package random.barnacle.nav

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import random.barnacle.R
import random.barnacle.screens.EarnScreen
import random.barnacle.ui.screens.FavoritesScreen
import random.barnacle.ui.screens.NFTsScreen
import random.barnacle.ui.screens.TokensScreen
import random.barnacle.screens.WalletScreen
import random.barnacle.ui.screens.AnalyticsScreen

@Composable
fun AppNavGraph() {
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

@Composable
fun MainMenu(navController: NavHostController) {
    NavButtons(navController)
    Logo()
}
@Composable
fun NavButtons(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 144.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { navController.navigate(Routes.FAVORITES) },
                modifier = Modifier.padding(4.dp)
            ) {
                Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = null)
            }

            Button(
                onClick = { navController.navigate(Routes.TOKENS) },
                modifier = Modifier.padding(4.dp)
            ) {
                Text(text = "Tokens")
            }

            Button(
                onClick = { navController.navigate(Routes.NFTs) },
                modifier = Modifier.padding(4.dp)
            ) {
                Text(text = "NFTs")
            }

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 80.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { navController.navigate(Routes.EARN) },
                modifier = Modifier.padding(4.dp)
            ) {
                Text(text = "Earn")
            }

            Button(
                onClick = { navController.navigate(Routes.WALLET) },
                modifier = Modifier.padding(4.dp)
            ) {
                Text(text = "Wallet")
            }

            Button(
                onClick = { navController.navigate(Routes.ANALYTICS) },
                modifier = Modifier.padding(4.dp)
            ) {
                Text(text = "Analytics")
            }
        }

    }
}
@Composable
fun Logo() {
    val logo = painterResource(id = R.mipmap.logo)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        contentAlignment = Alignment.BottomCenter,
    ) {
        Image(
            painter = logo,
            contentDescription = null,
            modifier = Modifier.size(64.dp),
            contentScale = ContentScale.Fit
        )
    }
}

