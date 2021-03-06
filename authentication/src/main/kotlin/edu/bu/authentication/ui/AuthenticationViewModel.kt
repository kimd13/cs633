package edu.bu.authentication.ui

import androidx.lifecycle.ViewModel
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.bu.authentication.ui.model.ActionState
import edu.bu.authentication.ui.model.ActionState.*
import edu.bu.authentication.ui.model.AuthenticationState
import edu.bu.authentication.ui.model.AuthenticationState.*
import edu.bu.authentication.util.AlertManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel @Inject constructor(
    private val firebaseAuthentication: FirebaseAuth,
    private val alertManager: AlertManager
) : ViewModel() {

    private val user: FirebaseUser? = firebaseAuthentication.currentUser

    private val _actionState: MutableStateFlow<ActionState> =
        MutableStateFlow(getInitialActionState())
    val actionState: StateFlow<ActionState> =
        _actionState

    private val _authenticationState: MutableStateFlow<AuthenticationState> =
        MutableStateFlow(Idle)
    val authenticationState: StateFlow<AuthenticationState> = _authenticationState

    private fun getInitialActionState(): ActionState {
        return if (isUserSignedIn()) {
            SIGNED_IN
        } else {
            SIGN_IN
        }
    }

    private fun isUserSignedIn(): Boolean =
        user != null

    fun signUpUser(
        email: String,
        password: String,
        reEnteredPassword: String
    ) {
        if (verifyInputs(email, password, reEnteredPassword).not()) return
        _authenticationState.value = Loading
        firebaseAuthentication.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                handleUserSignInResult(task)
            }
    }

    fun signInUser(
        email: String,
        password: String
    ) {
        if (verifyInputs(email, password).not()) return
        _authenticationState.value = Loading
        firebaseAuthentication.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                handleUserSignInResult(task)
            }
    }

    private fun verifyInputs(
        email: String,
        password: String,
        reEnteredPassword: String? = null
    ): Boolean =
        verifyEmail(email) &&
                verifyPassword(password) &&
                verifyReEnteredPassword(password, reEnteredPassword)

    private fun verifyEmail(email: String): Boolean =
        email.isNotEmpty().also {
            if (!it) {
                val message = "Invalid email."
                _authenticationState.value = Error(message)
                alertManager.alert(message)
            }
        }

    private fun verifyPassword(password: String): Boolean =
        password.isNotEmpty().also {
            if (!it) {
                val message = "Invalid password."
                _authenticationState.value = Error(message)
                alertManager.alert(message)
            }
        }

    private fun verifyReEnteredPassword(password: String, reEnteredPassword: String?): Boolean {
        if (reEnteredPassword == null) return true
        return (reEnteredPassword == password).also {
            if (!it) {
                val message = "Re-entered password does not match."
                _authenticationState.value = Error(message)
                alertManager.alert(message)
            }
        }
    }


    private fun handleUserSignInResult(task: Task<AuthResult>) {
        if (task.isSuccessful) {
            _authenticationState.value = Success
            _actionState.value = SIGNED_IN
        } else {
            val message = task.exception?.localizedMessage
            _authenticationState.value =
                Error(message)
            alertManager.alert(message ?: "Something went wrong.")
        }
    }

    fun singOut() {
        firebaseAuthentication.signOut()
    }

    fun onSignUpClicked() {
        _authenticationState.value = Idle
        _actionState.value = SIGN_UP
    }

    fun onSignInClicked() {
        _authenticationState.value = Idle
        _actionState.value = SIGN_IN
    }
}