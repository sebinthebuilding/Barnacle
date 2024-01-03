import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun TokensScreen(navController: NavHostController,
                 apicall: String){
    MainMenu(navController = navController)
    Text(text = apicall)
}
