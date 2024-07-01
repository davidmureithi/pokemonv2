package david.pokeman.oldmutual.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import david.pokeman.oldmutual.LIMIT
import david.pokeman.oldmutual.data.remote.response.PokemonResponse
import david.pokeman.oldmutual.data.remote.response.SinglePokemonResponse
import david.pokeman.oldmutual.data.repositories.PokemonRepository
import david.pokeman.utilities.NetworkResource
import david.pokeman.utilities.extractId
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokeManViewModel @Inject constructor(private val pokemonRepository: PokemonRepository) : ViewModel() {
	
	private var _selectedUrl = MutableLiveData<String>()
	val selectedUrl: LiveData<String> = _selectedUrl
	
	private var _pokemonResponseNetworkResource = MutableStateFlow<NetworkResource<PokemonResponse>>(NetworkResource.Loading)
	val pokemonResponseNetworkResource: StateFlow<NetworkResource<PokemonResponse>> = _pokemonResponseNetworkResource
	
	private var _singlePokemonResponseNetworkResource = MutableLiveData<NetworkResource<SinglePokemonResponse>>(NetworkResource.Loading)
	val singlePokemonResponseNetworkResource: LiveData<NetworkResource<SinglePokemonResponse>> = _singlePokemonResponseNetworkResource
	
	init {
		getPokemonList(LIMIT)
	}
	
	private fun getPokemonList(limit: String) {
		viewModelScope.launch(Dispatchers.IO) {
			pokemonRepository.getPokemonList(limit).collectLatest { response ->
				_pokemonResponseNetworkResource.value = response
			}
		}
	}
	
	fun getSinglePokemon() {
		val url = selectedUrl.value
		if (url.isNullOrEmpty()) {
			_singlePokemonResponseNetworkResource.postValue(
				NetworkResource.Failure(
					isNetworkError = true,
					errorCode = 404,
					errorBody = "Could not fetch : Empty URL"
				)
			)
			return
		}
		
		viewModelScope.launch(Dispatchers.IO) {
			try {
				//Todo !!
				val response = pokemonRepository.getSinglePokemon(selectedUrl.value!!.extractId())
				_singlePokemonResponseNetworkResource.postValue(response.value)
			} catch (e: Exception) {
				_singlePokemonResponseNetworkResource.postValue(
					NetworkResource.Failure(
						isNetworkError = true,
						errorCode = 404,
						errorBody = e.message
					)
				)
			}
		}
	}
	
	fun updateSelectedUrl(url: String) {
		_selectedUrl.value = url
	}
}