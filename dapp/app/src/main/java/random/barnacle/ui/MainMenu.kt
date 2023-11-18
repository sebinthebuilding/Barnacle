package random.barnacle.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import random.barnacle.R

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
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 96.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { navController.navigate(Routes.FAVORITES) },
                modifier = Modifier
                    .padding(4.dp)
            ) {
                Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = null)
            }

            Button(
                onClick = { navController.navigate(Routes.TOKENS) },
                modifier = Modifier
                    .padding(4.dp)
            ) {
                Text(text = "Tokens")
            }

            Button(
                onClick = { navController.navigate(Routes.NFTs) },
                modifier = Modifier
                    .padding(4.dp)
            ) {
                Text(text = "NFTs")
            }

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { navController.navigate(Routes.EARN) },
                modifier = Modifier
                    .padding(4.dp)
            ) {
                Text(text = "Earn")
            }

            Button(
                onClick = { navController.navigate(Routes.HOLDINGS) },
                modifier = Modifier
                    .padding(4.dp)
                    .wrapContentSize()
            ) {
                Text(text = "Holdings")
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

object Routes {
    const val FAVORITES = "/FAVORITES"
    const val TOKENS = "/TOKENS"
    const val NFTs = "/NFTs"
    const val EARN = "/EARN"
    const val HOLDINGS = "/HOLDINGS"
    const val ANALYTICS = "/ANALYTICS"
}