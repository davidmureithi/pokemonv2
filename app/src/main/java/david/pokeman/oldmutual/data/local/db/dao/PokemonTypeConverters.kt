package david.pokeman.oldmutual.data.local.db.dao

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import david.pokeman.oldmutual.data.remote.response.Results
import david.pokeman.oldmutual.data.remote.response.Sprites
import david.pokeman.oldmutual.data.remote.response.Stat
import david.pokeman.oldmutual.data.remote.response.Stats

class PokemonTypeConverters {
	
	@TypeConverter
	fun fromResultsList(results: List<Results>): String {
		val gson = Gson()
		val type = object : TypeToken<List<Results>>() {}.type
		return gson.toJson(results, type)
	}
	
	@TypeConverter
	fun toResultsList(resultsString: String): List<Results> {
		val gson = Gson()
		val type = object : TypeToken<List<Results>>() {}.type
		return gson.fromJson(resultsString, type)
	}
	
	@TypeConverter
	fun fromSprites(sprites: Sprites): String {
		return Gson().toJson(sprites)
	}
	
	@TypeConverter
	fun toSprites(spritesString: String): Sprites {
		return Gson().fromJson(spritesString, Sprites::class.java)
	}
	
	@TypeConverter
	fun fromStatsList(stats: List<Stats>): String {
		return Gson().toJson(stats)
	}
	
	@TypeConverter
	fun toStatsList(statsString: String): List<Stats> {
		val listType = object : TypeToken<List<Stats>>() {}.type
		return Gson().fromJson(statsString, listType)
	}
	
	@TypeConverter
	fun fromStat(stat: Stat): String {
		return Gson().toJson(stat)
	}
	
	@TypeConverter
	fun toStat(statString: String): Stat {
		return Gson().fromJson(statString, Stat::class.java)
	}
}