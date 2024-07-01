package david.pokeman.oldmutual.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import david.pokeman.oldmutual.DATABASE_NAME
import david.pokeman.oldmutual.data.local.db.dao.PokemonResponseDao
import david.pokeman.oldmutual.data.local.db.dao.PokemonTypeConverters
import david.pokeman.oldmutual.data.local.db.dao.SinglePokemonResponseDao
import david.pokeman.oldmutual.data.remote.response.PokemonResponse
import david.pokeman.oldmutual.data.remote.response.SinglePokemonResponse

@Database(
	entities = [
		PokemonResponse::class,
		SinglePokemonResponse::class
	],
	exportSchema = false, version = 1
)
@TypeConverters(PokemonTypeConverters::class)
abstract class PokemanDatabase : RoomDatabase() {
	
	abstract fun pokemanResponseDao(): PokemonResponseDao
	
	abstract fun singlePokemanResponseDao(): SinglePokemonResponseDao
	
	companion object {
		private var INSTANCE: PokemanDatabase? = null
		
		@Synchronized
		fun getInstance(context: Context): PokemanDatabase {
			if (INSTANCE == null) {
				INSTANCE = Room
					.databaseBuilder(
						context.applicationContext,
						PokemanDatabase::class.java,
						DATABASE_NAME
					).fallbackToDestructiveMigration()
					.build()
			}
			return INSTANCE!!
		}
	}
}