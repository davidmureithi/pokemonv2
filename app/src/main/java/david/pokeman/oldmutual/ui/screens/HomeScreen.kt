package david.pokeman.oldmutual.ui.screens

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import david.pokeman.oldmutual.TAG
import david.pokeman.oldmutual.ui.components.ProgressLoader
import david.pokeman.oldmutual.ui.viewmodel.PokeManViewModel
import david.pokeman.utilities.NetworkResource

@Composable
fun HomeScreen(
	navController: NavController,
	pokeManViewModel: PokeManViewModel = hiltViewModel()
) {
	val pokeManResponseResourceState by pokeManViewModel.pokemonResponseNetworkResource.collectAsState()
	when (pokeManResponseResourceState) {
		is NetworkResource.Loading -> {
			Log.d(TAG, "NetworkResource.Loading")
			ProgressLoader()
		}
		
		is NetworkResource.Success -> {
			val response = (pokeManResponseResourceState as NetworkResource.Success).data
			Log.d(TAG, "NetworkResource.Success $response")
			PokeManListScreen(
				navController = navController,
				response = response
			)
		}
		
		is NetworkResource.Failure -> {
			val response = (pokeManResponseResourceState as NetworkResource.Failure)
			Log.d(TAG, "NetworkResource.Error ${response.errorBody}")
		}
	}
}

@Preview
@Composable
fun HomeScreenPreview() {
	HomeScreen(navController = rememberNavController())
}