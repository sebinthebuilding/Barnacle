
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
        TabButton(
            text = "USDC",
            onClick = { /* Handle USDC button click */ }
        )

        TabButton(
            text = "SOL",
            onClick = { /* Handle SOL button click */ }
        )
    }
}

@Composable
fun TabButton(text: String, onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp), // Adjust padding as needed
        contentPadding = ButtonDefaults.ContentPadding
    ) {
        Text(text = text)
    }
}

// Custom shape for rounded tab

