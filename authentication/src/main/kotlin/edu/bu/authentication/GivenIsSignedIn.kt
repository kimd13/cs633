package edu.bu.authentication

import androidx.compose.runtime.Composable

@Composable
fun GivenIsSignedIn(
    content: @Composable (Boolean) -> Unit
) {
    content(true)
}