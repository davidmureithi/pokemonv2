package david.pokeman.oldmutual.data.remote.network

import david.pokeman.oldmutual.data.remote.response.PokemonResponse
import david.pokeman.oldmutual.data.remote.response.SinglePokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {
	@GET("api/v2/pokemon?limit=100&offset=100")
	suspend fun getPokemonList(): PokemonResponse
	
	@GET("api/v2/pokemon/{id}")
	suspend fun getSinglePokemon(
		@Path("id") id: Int
	): SinglePokemonResponse
}