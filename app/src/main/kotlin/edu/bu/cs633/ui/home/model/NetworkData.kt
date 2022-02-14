package edu.bu.cs633.ui.home.model

sealed class NetworkData<out T : Any> {
    class Success<out T : Any>(val data: T) : NetworkData<T>()
    class Failure(val exception: Exception) : NetworkData<Nothing>()
    object Loading : NetworkData<Nothing>()
}