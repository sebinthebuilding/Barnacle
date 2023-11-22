package random.barnacle.ui.screens.tokens.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import random.barnacle.domain.models.TokenModel

@Composable
fun PairCardContents(token: TokenModel, usdcPrice: Double) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {

        AsyncImage(
            model = token.logoURI,
            contentDescription = null,
            modifier = Modifier
                .size(36.dp) // Set a fixed size (adjust as needed)
                .clip(shape = CircleShape),
            )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = "1 ${token.symbol}",
            style = TextStyle(fontSize = 16.sp),
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "$usdcPrice USDC",
            style = TextStyle(fontSize = 16.sp),
        )
    }
}