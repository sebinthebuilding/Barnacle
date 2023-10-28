package random.barnacle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import random.barnacle.nav.NavGraph
import random.barnacle.theme.BarnacleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BarnacleTheme(darkTheme = true) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //BarnacleApp()
                    AllTokens()
                }
            }
        }
    }
}

@Composable
fun BarnacleApp() {
    NavGraph()
}

@Composable
fun AllTokens() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val barnacleViewModel: BarnacleViewModel = viewModel()
        HomeScreen(
            barnacleUiState = barnacleViewModel.barnacleUiState
        )
    }
}