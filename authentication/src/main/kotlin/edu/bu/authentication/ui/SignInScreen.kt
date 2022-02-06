package edu.bu.authentication.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import edu.bu.authentication.R
import edu.bu.authentication.ui.model.AuthenticationState.Error

@Composable
fun SignInScreen(
    authenticationViewModel: AuthenticationViewModel,
) {
    val authenticationState by remember(authenticationViewModel) {
        authenticationViewModel.authenticationState
    }.collectAsState()

    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    val spacing = 16.dp

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        AuthenticationBanner(
            title = "Sign In",
            description = "Please sign in to continue.",
            image = R.drawable.sign_in_image
        )
        Spacer(modifier = Modifier.height(spacing))
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
        Spacer(modifier = Modifier.height(spacing))
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
        Spacer(modifier = Modifier.height(spacing))
        Link(
            text = "Sign Up",
            sendTo = { authenticationViewModel.onSignUpClicked() }
        )
    }
}