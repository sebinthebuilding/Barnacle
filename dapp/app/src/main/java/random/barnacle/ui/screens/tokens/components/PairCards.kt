package random.barnacle.ui.screens.tokens.components

import PairDetails
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import random.barnacle.domain.models.TokenModel
import random.barnacle.ui.nav.Routes

@Composable
fun PairCards(token: TokenModel, usdcPrices: Map<String, Double>) {
    val usdcPrice: Double? = usdcPrices[token.address] ?: 0.0

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "p") {
        composable(Routes.PAIR_DETAILS) {
            if (usdcPrice != null) {
                PairDetails(token = token, usdcPrice = usdcPrice )
            }
        }

        composable("p") {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .clickable {
                        navController.navigate(Routes.PAIR_DETAILS) {
                            popUpTo("p") { inclusive = true }
                        }
                    },
                shape = RoundedCornerShape(12.dp), // Rounded corners
            ) {
                if (usdcPrice != null) {
                    PairCardContents(token, usdcPrice)
                }
            }
        }
    }
}