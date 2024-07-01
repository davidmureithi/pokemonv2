package david.pokeman.oldmutual.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import david.pokeman.oldmutual.TAG
import david.pokeman.oldmutual.data.remote.response.PokemonResponse
import david.pokeman.oldmutual.ui.components.SearchBar
import david.pokeman.oldmutual.ui.components.SinglePokemonComponent
import david.pokeman.oldmutual.ui.navigation.Routes
import david.pokeman.oldmutual.ui.viewmodel.PokeManViewModel

@Composable
fun PokeManListScreen(
	response: PokemonResponse,
	navController: NavController,
	pokeManViewModel: PokeManViewModel = hiltViewModel()
) {
	var query by remember { mutableStateOf("") }
	val filteredResults = remember(query) {
		response.results.filter {
			it.name.contains(query, ignoreCase = true)
		}
	}
	
	Scaffold(
		topBar = {
			SearchBar(
				query = query,
				onQueryChange = { newQuery -> query = newQuery },
				onSearchClicked = { }
			)
		},
		content = { padding ->
			LazyVerticalGrid(
				columns = GridCells.Fixed(2),
				modifier = Modifier
					.fillMaxSize()
					.padding(padding)
					.padding(8.dp)
			) {
				items(filteredResults) {
					SinglePokemonComponent(results = it) {
						Log.d(TAG, "URL ${it.url}")
						pokeManViewModel.updateSelectedUrl(it.url)
						navController.navigate(Routes.DETAILS_SCREEN)
					}
				}
			}
		}
	)
}