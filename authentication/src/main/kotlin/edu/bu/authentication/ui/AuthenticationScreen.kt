package edu.bu.authentication.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import edu.bu.authentication.ui.model.ActionState.*

@Composable
fun AuthenticationScreen(
    onFinish: () -> Unit,
    authenticationViewModel: AuthenticationViewModel = hiltViewModel()
) {
    val actionState by remember(authenticationViewModel) { authenticationViewModel.actionState }
        .collectAsState()

    when (actionState) {
        SIGN_IN -> SignInScreen(authenticationViewModel = authenticationViewModel)
        SIGN_UP -> SignUpScreen(authenticationViewModel = authenticationViewModel)
        SIGNED_IN -> onFinish()
    }
}