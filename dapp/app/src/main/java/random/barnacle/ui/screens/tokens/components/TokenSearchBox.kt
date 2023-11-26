
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun TokenSearchBox(
    tokenSearchQuery: TextFieldValue,
    onSearchQueryChange: (TextFieldValue) -> Unit
) {
    BasicTextField(
        value = tokenSearchQuery,
        onValueChange = {
            onSearchQueryChange(it)
        },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(
                width = 1.dp,
                color = Color.DarkGray,
                shape = RoundedCornerShape(24.dp)
            )
            .height(38.dp), // Adjusted height
        textStyle = LocalTextStyle.current.copy(color = Color.White),
        cursorBrush = SolidColor(Color.White),
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Image(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .padding(2.dp),
                    colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color.White),
                    alignment = Alignment.CenterEnd
                )
                innerTextField()
            }
        }
    )
}