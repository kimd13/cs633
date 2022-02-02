package edu.bu.authentication.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import edu.bu.authentication.ui.model.AuthenticationState.Error

@Composable
fun SignInScreen(
    authenticationViewModel: AuthenticationViewModel
) {
    val authenticationState by remember(authenticationViewModel) {
        authenticationViewModel.authenticationState
    }.collectAsState()

    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    Column {
        EmailEditBox(
            email = email,
            onEmailChange = { email = it },
            isError = authenticationState is Error
        )
        PasswordEditBox(
            password = password,
            onPasswordChange = { password = it },
            isError = authenticationState is Error
        )
        Button(
            onClick = {
                authenticationViewModel.signInUser(
                    email = email,
                    password = password
                )
            }
        ) {
            Text(
                text = "Sign In"
            )
        }
    }
}