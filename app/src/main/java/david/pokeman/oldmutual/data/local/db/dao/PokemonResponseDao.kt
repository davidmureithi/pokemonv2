package david.pokeman.oldmutual.data.local.db.dao

import androidx.room.Dao
import androidx.room.Query
import david.pokeman.oldmutual.data.remote.response.PokemonResponse

@Dao
interface PokemonResponseDao : BaseDao<PokemonResponse> {
	
	@Query("SELECT * FROM pokemons")
	fun getPokemonList(): PokemonResponse
	
	@Query("DELETE FROM pokemons")
	fun nukeTable()
}