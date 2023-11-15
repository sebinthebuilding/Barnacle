package random.barnacle.ui.screens.tokens.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.flow.Flow
import random.barnacle.data.models.PriceResponse
import random.barnacle.data.models.TokenResponse

@Composable
fun PairCard(tokenResponse: TokenResponse, usdcPrice: PriceResponse, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
    ) {
        Column(
            modifier = Modifier
                .padding(9.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = "1 ${tokenResponse.symbol}",
                    style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
                )
                Spacer(modifier = Modifier.width(40.dp))
                Text(
                    text = "${usdcPrice.timeTaken} USDC",
                    style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
                )
            }

        }
    }
}