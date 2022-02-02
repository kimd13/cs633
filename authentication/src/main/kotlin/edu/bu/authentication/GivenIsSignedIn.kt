package edu.bu.authentication

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun GivenIsSignedIn(
    content: @Composable (Boolean) -> Unit,
    authenticationViewModel: AuthenticationViewModel = hiltViewModel()
) {
    content(true)
}