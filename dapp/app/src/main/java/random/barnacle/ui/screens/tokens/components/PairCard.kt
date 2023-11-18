package random.barnacle.ui.screens.tokens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import random.barnacle.data.models.PriceResponse
import random.barnacle.data.models.TokenResponse
import random.barnacle.domain.models.TokenModel

@Composable
fun PairCard(token: TokenModel, usdcPrices: Map<String, Double>, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp), // Adjust padding
        shape = RoundedCornerShape(12.dp), // Rounded corners
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Customized icon with padding
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .clickable {  }
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Token symbol with different styling
            Text(
                text = "1 ${token.symbol}",
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
            )

            Spacer(modifier = Modifier.weight(1f))

            // USDC value with different styling
            val usdcValue = usdcPrices[token.address]?.toString() ?: "n/a"

            Text(
                text = "$usdcValue USDC",
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
            )
        }
    }
}
