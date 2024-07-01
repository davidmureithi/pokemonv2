package david.pokeman.oldmutual.data.remote.response

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "single_pokemon")
data class SinglePokemonResponse(
	@PrimaryKey(autoGenerate = true) val id: Int = 0,
	val name: String = "",
	val sprites: Sprites = Sprites(),
	val stats: List<Stats>,
	val height: Int,
	val weight: Int,
)

data class Stats(
	val baseStat: Int = 0,
	val effort: Int = 0,
	val stat: Stat = Stat()
)

data class Stat(
	val name: String = "",
	val url: String = ""
)

data class Sprites(
	val backDefault: String = "",
	val backShiny: String = "",
	val frontDefault: String = "",
	val frontShiny: String = ""
)