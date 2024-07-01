package david.pokeman.oldmutual.data.local.db.dao

import androidx.room.Dao
import androidx.room.Query
import david.pokeman.oldmutual.data.remote.response.PokemonResponse
import david.pokeman.oldmutual.data.remote.response.SinglePokemonResponse

@Dao
interface SinglePokemonResponseDao : BaseDao<PokemonResponse> {
	
	@Query("SELECT * FROM single_pokemon WHERE id = :id LIMIT 1")
	suspend fun getSinglePokemon(id: Int): SinglePokemonResponse
	
	@Query("DELETE FROM pokemons")
	fun nukeTable()
}