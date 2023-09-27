package random.barnacle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import random.barnacle.ui.theme.BarnacleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BarnacleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavButtons()
                }
            }
        }
    }
}

@Composable
fun NavButtons(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), // Apply padding to the outer Box
        contentAlignment = Alignment.BottomCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 96.dp), // Keep bottom padding here
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.padding(4.dp)
                ) {
                    Text(text = stringResource(R.string.watchlists_btn))
                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.padding(4.dp)
                ) {
                    Text(text = stringResource(R.string.tokens_btn))
                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.padding(4.dp)
                ) {
                    Text(text = stringResource(R.string.liquidity_btn))
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.padding(4.dp)
                ) {
                    Text(text = stringResource(R.string.holdings_btn))
                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.padding(4.dp)
                ) {
                    Text(text = stringResource(R.string.analytics_btn))
                }
            }
        }
    }
}


@Composable
fun Logo() {
    val logo = painterResource(id = R.mipmap.logo)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        contentAlignment = Alignment.BottomCenter,
    ) {
        Image(
            painter = logo,
            contentDescription = null,
            modifier = Modifier.size(64.dp),
            contentScale = ContentScale.Fit
        )
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BarnacleTheme {
        NavButtons()
        Logo()
    }
}