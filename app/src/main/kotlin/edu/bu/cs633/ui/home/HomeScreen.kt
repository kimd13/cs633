package edu.bu.cs633.ui.home

import androidx.compose.runtime.Composable
import edu.bu.authentication.ui.SignOutButton

@Composable
fun HomeScreen(
    navigateToAuthentication: () -> Unit
) {
    SignOutButton(navigateToAuthentication = navigateToAuthentication)
}