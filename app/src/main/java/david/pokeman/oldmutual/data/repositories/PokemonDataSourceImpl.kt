package david.pokeman.oldmutual.data.repositories

import david.pokeman.oldmutual.data.local.db.PokemanDatabase
import david.pokeman.oldmutual.data.remote.network.PokemonApi
import david.pokeman.oldmutual.data.remote.response.PokemonResponse
import david.pokeman.oldmutual.data.remote.response.SinglePokemonResponse
import javax.inject.Inject

class PokemonDataSourceImpl @Inject constructor(
	private val pokemonApi: PokemonApi,
	private val pokemanDatabase: PokemanDatabase
) : PokemonDataSource {
	override suspend fun getPokemonList(limit: String): PokemonResponse = pokemonApi.getPokemonList()
//	{
//		return if (pokemanDatabase.pokemanResponseDao().getPokemonList().results.isNotEmpty()) {
//			val response = pokemonApi.getPokemonList()
//			pokemanDatabase.pokemanResponseDao().insert(response)
//			return response
//		} else {
//			pokemonApi.getPokemonList()
//		}
//	}
	
	override suspend fun getSinglePokemon(id: Int): SinglePokemonResponse = pokemonApi.getSinglePokemon(id)
//	{
//		val localPokemon = pokemanDatabase.singlePokemanResponseDao().getSinglePokemon(id)
//
//		return if (localPokemon != null) {
//			localPokemon
//		} else {
//			val remotePokemon = pokemonApi.getSinglePokemon(id)
//			pokemanDatabase.pokemanResponseDao().insert(remotePokemon)
//			remotePokemon
//		}
//	}
}