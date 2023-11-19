package random.barnacle.ui.screens.tokens.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        // Customized icon with padding
        Icon(
            imageVector = Icons.Default.FavoriteBorder,
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .clickable { }
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