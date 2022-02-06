package edu.bu.authentication.ui

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SignOutButton(
    navigateToAuthentication: () -> Unit,
    authenticationViewModel: AuthenticationViewModel = hiltViewModel()
) {
    Button(
        onClick = {
            authenticationViewModel.singOut()
            navigateToAuthentication()
        }
    ) {
        Text(text = "Sign Out")
    }
}