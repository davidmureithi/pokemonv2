package david.pokeman.oldmutual.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import david.pokeman.oldmutual.R
import david.pokeman.oldmutual.data.remote.response.Results

@Composable
fun SinglePokemonComponent(results: Results, onItemClick: () -> Unit) {
	Column(
		modifier = Modifier
			.fillMaxWidth()
			.padding(8.dp)
			.wrapContentHeight()
			.background(Color.White)
			.clickable { onItemClick.invoke() },
	) {
		AsyncImage(
			modifier = Modifier
				.fillMaxWidth()
				.height(240.dp),
			model = results.url,
			contentDescription = "",
			contentScale = ContentScale.Crop,
			placeholder = painterResource(id = R.drawable.pokeman),
			error = painterResource(id = R.drawable.pokeman)
		)
		Spacer(modifier = Modifier.size(20.dp))
		TextComponent(text = results.name)
	}
}

@Preview
@Composable
fun NewsRowComponentScreen() {
	val results = Results(name = "David", url = "")
	SinglePokemonComponent(results = results, {})
}