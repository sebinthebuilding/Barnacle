package random.barnacle

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import random.barnacle.ui.AppUi
import random.barnacle.ui.theme.BarnacleTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BarnacleTheme(darkTheme = true) {
                Scaffold(
                    topBar = {
                        AppBar(
                            title = "Welcome [USER SOL ADDRESS]"
                        )
                    },
                    content = {
                        Surface(
                            modifier = Modifier
                                .fillMaxSize()
                                .statusBarsPadding(),
                            color = MaterialTheme.colorScheme.background
                        ) {
                            AppUi()
                        }
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(title: String) {
    TopAppBar(
        title = {
            Text(text = title)
        },
    )
}

