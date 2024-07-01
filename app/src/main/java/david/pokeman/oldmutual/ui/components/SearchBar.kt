package david.pokeman.oldmutual.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(
	query: String,
	onQueryChange: (String) -> Unit,
	onSearchClicked: () -> Unit
) {
	Box(
		modifier = Modifier
			.fillMaxWidth()
			.padding(8.dp)
			.background(Color.White, shape = RoundedCornerShape(8.dp))
	) {
		Row(
			verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
			modifier = Modifier.fillMaxWidth()
		) {
			TextField(
				value = query,
				onValueChange = onQueryChange,
				placeholder = { Text(text = "Search...") },
				modifier = Modifier.weight(1f),
				singleLine = true
			)
			IconButton(onClick = onSearchClicked) {
				Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
			}
		}
	}
}

@Preview
@Composable
fun SearchBarPreview() {
	SearchBar("", {}, {})
}