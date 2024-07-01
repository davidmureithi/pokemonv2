package david.pokeman.oldmutual.data.repositories

import david.pokeman.oldmutual.data.remote.response.PokemonResponse
import david.pokeman.oldmutual.data.remote.response.SinglePokemonResponse

interface PokemonDataSource {
	suspend fun getPokemonList(limit: String): PokemonResponse
	suspend fun getSinglePokemon(id: Int): SinglePokemonResponse
}