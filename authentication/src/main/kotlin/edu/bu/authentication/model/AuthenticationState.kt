package edu.bu.authentication.model

sealed class AuthenticationState {
    object Idle : AuthenticationState()
    class Error(val message: String?) : AuthenticationState()
    object Loading : AuthenticationState()
    object Success : AuthenticationState()
}