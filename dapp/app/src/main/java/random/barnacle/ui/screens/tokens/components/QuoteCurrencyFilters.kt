
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun QuoteCurrencyFilters() {

}

@Composable
fun TabButton(text: String, onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick,

    ) {
        Text(text = text)
    }
}

// Custom shape for rounded tab

