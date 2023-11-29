
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import random.barnacle.R
import random.barnacle.ui.nav.Routes
import random.barnacle.ui.screens.analytics.AnalyticsScreen
import random.barnacle.ui.screens.tokens.TokensScreen
import random.barnacle.ui.screens.wallet.WalletScreen
import random.barnacle.ui.view_models.PriceViewModel
import random.barnacle.ui.view_models.TokensViewModel

@Composable
fun AppNav() {
    val navController = rememberNavController()

    MainMenu(navController = navController)

    val tokensViewModel: TokensViewModel = viewModel(factory = TokensViewModel.Factory)
    val priceViewModel: PriceViewModel = viewModel(factory = PriceViewModel.Factory)

    NavHost(navController = navController, startDestination = Routes.WALLET) {
        composable(Routes.TOKENS) {
            TokensScreen(tokensViewModel, priceViewModel)
        }

        composable(Routes.WALLET) {
            WalletScreen(navController = navController)
        }

        composable(Routes.ANALYTICS) {
            AnalyticsScreen(navController = navController)
        }
    }
}

@Composable
fun MainMenu(navController: NavHostController) {
    NavButtons(navController)
}
@Composable
fun NavButtons(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.BottomCenter
    ) {


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding() // Adjust left padding as needed
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 32.dp),
                horizontalArrangement = Arrangement.Start,
            ) {
                Spacer(modifier = Modifier.padding(16.dp))

                Image(
                    painter = painterResource(id = R.mipmap.logo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(64.dp),
                )

                Spacer(modifier = Modifier.padding(8.dp))

                Button(
                    onClick = { navController.navigate(Routes.TOKENS) },
                    modifier = Modifier
                        .padding(4.dp)
                ) {
                    Text(text = "Tokens")
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = { navController.navigate(Routes.WALLET) },
                    modifier = Modifier
                        .padding(4.dp)
                        .wrapContentSize()
                ) {
                    Text(text = "Wallet")
                }

                Button(
                    onClick = { navController.navigate(Routes.ANALYTICS) },
                    modifier = Modifier
                        .padding(4.dp)
                        .wrapContentSize()
                ) {
                    Text(text = "Analytics")
                }
            }
        }
    }
}

