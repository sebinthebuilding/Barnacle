package random.barnacle.ui.screens.tokens.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun QuoteCurrencyFilters() {
    Row {
        OutlinedButton(
            onClick = { /* Handle USDC button click */ },
            contentPadding = ButtonDefaults.ContentPadding,
            modifier = Modifier.padding(8.dp) // Adjust padding as needed
        ) {
            Text(text = "USDC")
        }

        OutlinedButton(
            onClick = { /* Handle SOL button click */ },
            contentPadding = ButtonDefaults.ContentPadding,
            modifier = Modifier.padding(8.dp) // Adjust padding as needed
        ) {
            Text(text = "SOL")
        }
    }
}