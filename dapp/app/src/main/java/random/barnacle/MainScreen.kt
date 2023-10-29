package random.barnacle

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen(barnacleUiState: String) {
    ResultScreen(barnacleUiState)
}

@Composable
fun ResultScreen(tokens: String) {
    Text(text = tokens)
}

