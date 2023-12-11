import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun TokenSearchBox(
    tokenSearchQuery: TextFieldValue,
    onSearchQueryChange: (TextFieldValue) -> Unit,
) {
    var isFocused by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(
                width = 1.dp,
                color = if (isFocused || tokenSearchQuery.text.isNotEmpty()) Color.DarkGray else Color.Gray,
                shape = RoundedCornerShape(24.dp)
            )
            .height(38.dp), // Adjusted height
        contentAlignment = Alignment.CenterStart
    ) {
        if (!isFocused && tokenSearchQuery.text.isEmpty()) {
            Image(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .padding(
                        start = 4.dp,
                    ),
                colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color.White),
            )
        }
        BasicTextField(
            value = tokenSearchQuery,
            onValueChange = {
                onSearchQueryChange(it)
            },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp),
            textStyle = LocalTextStyle.current.copy(color = Color.White),
            cursorBrush = SolidColor(Color.White)
        )
        LaunchedEffect(isFocused) {
            if (isFocused) {
                isFocused = false
            }
        }
        LaunchedEffect(tokenSearchQuery.text) {
            if (tokenSearchQuery.text.isNotEmpty()) {
                isFocused = true
            }
        }
    }
}
