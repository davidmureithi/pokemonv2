package david.pokeman.utilities

sealed class NetworkResource<out T> {
	data object Loading : NetworkResource<Nothing>()
	data class Success<T>(val data: T) : NetworkResource<T>()
	data class Failure(
		val isNetworkError: Boolean,
		val errorCode: Int?,
		val errorBody: Any?
	) : NetworkResource<Nothing>()
}