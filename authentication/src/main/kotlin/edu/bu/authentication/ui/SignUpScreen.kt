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
import edu.bu.authentication.ui.model.AuthenticationState

@Composable
fun SignUpScreen(
    authenticationViewModel: AuthenticationViewModel
) {
    val authenticationState by remember(authenticationViewModel) {
        authenticationViewModel.authenticationState
    }.collectAsState()

    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var reEnteredPassword by rememberSaveable { mutableStateOf("") }
    val spacing = 16.dp

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        AuthenticationBanner(
            title = "Sign Up",
            description = "Create an account to continue.",
            image = R.drawable.sign_up_image
        )
        Spacer(modifier = Modifier.height(spacing))
        EmailEditBox(
            email = email,
            onEmailChange = { email = it },
            isError = authenticationState is AuthenticationState.Error
        )
        PasswordEditBox(
            password = password,
            onPasswordChange = { password = it },
            isError = authenticationState is AuthenticationState.Error
        )
        ReEnterPasswordEditBox(
            password = reEnteredPassword,
            onPasswordChange = { reEnteredPassword = it },
            isError = authenticationState is AuthenticationState.Error
        )
        Spacer(modifier = Modifier.height(spacing))
        Button(
            onClick = {
                authenticationViewModel.signUpUser(
                    email = email,
                    password = password,
                    reEnteredPassword = reEnteredPassword
                )
            }
        ) {
            Text(
                text = "Sign Up"
            )
        }
        Spacer(modifier = Modifier.height(spacing))
        Link(
            text = "Sign In",
            sendTo = { authenticationViewModel.onSignInClicked() }
        )
    }
}