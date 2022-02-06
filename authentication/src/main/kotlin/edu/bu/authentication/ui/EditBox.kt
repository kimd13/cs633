package edu.bu.authentication.ui

import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun EmailEditBox(
    email: String,
    onEmailChange: (String) -> Unit,
    isError: Boolean
) {
    OutlinedTextField(
        value = email,
        label = { Text(text = "Email") },
        onValueChange = onEmailChange,
        isError = isError
    )
}

@Composable
fun PasswordEditBox(
    password: String,
    onPasswordChange: (String) -> Unit,
    isError: Boolean
) {
    OutlinedTextField(
        value = password,
        label = { Text(text = "Password") },
        onValueChange = onPasswordChange,
        isError = isError
    )
}

@Composable
fun ReEnterPasswordEditBox(
    password: String,
    onPasswordChange: (String) -> Unit,
    isError: Boolean
) {
    OutlinedTextField(
        value = password,
        label = { Text(text = "Re-enter Password") },
        onValueChange = onPasswordChange,
        isError = isError
    )
}