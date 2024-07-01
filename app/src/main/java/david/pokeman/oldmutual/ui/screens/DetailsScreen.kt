package david.pokeman.oldmutual.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
import david.pokeman.oldmutual.TAG
import david.pokeman.oldmutual.data.remote.response.SinglePokemonResponse
import david.pokeman.oldmutual.ui.components.ProgressLoader
import david.pokeman.oldmutual.ui.components.TextComponent
import david.pokeman.oldmutual.ui.components.TopBar
import david.pokeman.oldmutual.ui.viewmodel.PokeManViewModel
import david.pokeman.utilities.NetworkResource

@Composable
fun DetailsScreen(
	pokeManViewModel: PokeManViewModel = hiltViewModel()
) {
	val lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current
	var response by remember { mutableStateOf<NetworkResource<SinglePokemonResponse>>(NetworkResource.Loading) }
	
	LaunchedEffect(pokeManViewModel.selectedUrl) {
		pokeManViewModel.selectedUrl.observe(lifecycleOwner) { url ->
			Log.d("DetailScreen", "Observed URL: $url")
			if (!url.isNullOrEmpty()) {
				pokeManViewModel.getSinglePokemon()
			}
		}
	}
	
	pokeManViewModel.singlePokemonResponseNetworkResource.observe(lifecycleOwner) { resource ->
		response = resource
	}
	
	when (response) {
		is NetworkResource.Loading -> {
			Log.d(TAG, "NetworkResource.Loading")
			ProgressLoader()
		}
		
		is NetworkResource.Success -> {
			val res = (response as NetworkResource.Success).data
			Log.d(TAG, "NetworkResource.Success $res")
			Surface(
				modifier = Modifier.fillMaxSize(),
				color = Color.White
			) {
				Column(
					modifier = Modifier
						.fillMaxSize()
						.padding(16.dp)
				) {
					TopBar(title = res.name)
					Spacer(modifier = Modifier.size(60.dp))
					TextComponent(text = res.weight.toString(), textSize = 24.sp)
					Spacer(modifier = Modifier.size(60.dp))
				}
			}
		}
		
		is NetworkResource.Failure -> {
			val res = (response as NetworkResource.Failure)
			Log.d(TAG, "NetworkResource.Error ${res.errorBody}")
			TextComponent(text = res.errorBody.toString(), textSize = 24.sp)
		}
	}
}

@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview() {
	DetailsScreen()
}