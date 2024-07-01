package david.pokeman.oldmutual.data.remote.response

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemons")
data class PokemonResponse(
	@PrimaryKey(autoGenerate = true) val id: Int = 0,
	val name: String = "",
	val count: Int = 0,
	val next: String = "",
	val previous: String = "",
	val results: List<Results>
)

data class Results(
	val name: String = "",
	val url: String = ""
)