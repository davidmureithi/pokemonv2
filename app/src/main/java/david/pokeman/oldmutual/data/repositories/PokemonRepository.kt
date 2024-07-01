package david.pokeman.oldmutual.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import david.pokeman.oldmutual.data.remote.response.PokemonResponse
import david.pokeman.oldmutual.data.remote.response.SinglePokemonResponse
import david.pokeman.utilities.NetworkResource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PokemonRepository @Inject constructor(private val pokemonDataSourceImpl: PokemonDataSourceImpl) : BaseRepository() {
	
	suspend fun getPokemonList(limit: String): Flow<NetworkResource<PokemonResponse>> = flow {
		emit(NetworkResource.Loading)
		emit(NetworkResource.Success(pokemonDataSourceImpl.getPokemonList(limit)))
	}.catch { exception ->
		emit(
			NetworkResource.Failure(
				isNetworkError = true,
				errorCode = 404,
				errorBody = exception.localizedMessage ?: "An error occurred!"
			)
		)
	}
	
	suspend fun getSinglePokemon(id: Int): LiveData<NetworkResource<SinglePokemonResponse>> = liveData {
		emit(NetworkResource.Loading)
		val response = pokemonDataSourceImpl.getSinglePokemon(id)
		if (response.name.isNotEmpty()) {
			emit(NetworkResource.Success(response))
		} else {
			emit(
				NetworkResource.Failure(
					isNetworkError = true,
					errorCode = 404,
					errorBody = "An error occurred!"
				)
			)
		}
	}
}