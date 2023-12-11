import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import random.barnacle.domain.QuoteCurrencies
import random.barnacle.ui.screens.tokens.components.PairCards
import random.barnacle.ui.view_models.PricesViewModel
import random.barnacle.ui.view_models.TokensViewModel

@Composable
fun TokensScreen(
    tokensViewModel: TokensViewModel,
    pricesViewModel: PricesViewModel,
) {
    val allTokens = tokensViewModel.allTokensUiState
    val allPrices by pricesViewModel.allPricesUiState.collectAsState(initial = emptyMap())
    val selectedCurrency = pricesViewModel.selectedQuoteCurrency

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 64.dp,
                bottom = 176.dp
            )
    ) {
        // Content above buttons (e.g., LazyColumn)
        Column(
            modifier = Modifier.weight(1f)
        ) {
            PairCards(allTokens, allPrices, selectedCurrency.name)
        }

        // Buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ButtonItem(QuoteCurrencies.USDC.name) {
                pricesViewModel.stopPriceStream()
                pricesViewModel.selectQuoteCurrency(QuoteCurrencies.USDC)
            }
            Text(text = "|")
            ButtonItem(QuoteCurrencies.SOL.name) {
                pricesViewModel.stopPriceStream()
                pricesViewModel.selectQuoteCurrency(QuoteCurrencies.SOL)
            }
            Text(text = "|")
            ButtonItem(QuoteCurrencies.WBTC.name) {
                pricesViewModel.stopPriceStream()
                pricesViewModel.selectQuoteCurrency(QuoteCurrencies.WBTC)
            }
            Text(text = "|")
            ButtonItem(QuoteCurrencies.WETH.name) {
                pricesViewModel.stopPriceStream()
                pricesViewModel.selectQuoteCurrency(QuoteCurrencies.WETH)
            }
        }
    }
}

@Composable
fun ButtonItem(text: String, onClickAction: () -> Unit) {
    Text(
        text = text,
        modifier = Modifier
            .padding(
                vertical = 4.dp,
                horizontal = 4.dp
            )
            .clickable { onClickAction() }
    )
}
