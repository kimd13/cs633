package edu.bu.authentication

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable

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