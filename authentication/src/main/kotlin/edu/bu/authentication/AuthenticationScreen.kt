package edu.bu.authentication

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AuthenticationScreen(
    onFinish: () -> Unit,
    authenticationViewModel: AuthenticationViewModel = hiltViewModel()
) {
}