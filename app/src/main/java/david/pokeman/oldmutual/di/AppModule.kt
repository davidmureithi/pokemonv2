package david.pokeman.oldmutual.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import david.pokeman.oldmutual.BASE_URL
import david.pokeman.oldmutual.data.local.db.PokemanDatabase
import david.pokeman.oldmutual.data.remote.network.PokemonApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
	
	@Singleton
	@Provides
	fun provideDatabase(@ApplicationContext context: Context) = PokemanDatabase.getInstance(context)
	
	@Provides
	@Singleton
	fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
		.baseUrl(BASE_URL)
		.client(okHttpClient)
		.addConverterFactory(GsonConverterFactory.create())
		.build()
	
	@Provides
	@Singleton
	fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
		.connectTimeout(30, TimeUnit.SECONDS)
		.readTimeout(30, TimeUnit.SECONDS)
		.writeTimeout(30, TimeUnit.SECONDS)
		.addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
		.build()
	
	@Singleton
	@Provides
	fun provideApiService(retrofit: Retrofit): PokemonApi = retrofit.create(PokemonApi::class.java)

//	@Singleton
//	@Provides
//	fun providePokedexApi(retrofit: Retrofit): PokedexApi = retrofit.create(PokedexApi::class.java)
//
//	@Singleton
//	@Provides
//	fun providePokemonDao(db: PokedexDatabase) = db.pokedexDao()
//
//	@Singleton
//	@Provides
//	fun providePokemonRepository(api: PokedexApi) = PokedexRepository(api)
}