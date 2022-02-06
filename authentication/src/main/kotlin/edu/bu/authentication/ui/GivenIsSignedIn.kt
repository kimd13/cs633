package edu.bu.authentication.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import edu.bu.authentication.ui.model.ActionState.SIGNED_IN

@Composable
fun GivenIsSignedIn(
    content: @Composable (Boolean) -> Unit,
    authenticationViewModel: AuthenticationViewModel = hiltViewModel()
) {
    val actionState by remember(authenticationViewModel) { authenticationViewModel.actionState }
        .collectAsState()

    content(actionState == SIGNED_IN)
}