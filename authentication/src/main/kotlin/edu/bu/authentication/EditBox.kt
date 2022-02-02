package edu.bu.authentication

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
        placeholder = { Text(text = "Enter email.") },
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
        placeholder = { Text(text = "Enter password.") },
        label = { Text(text = "Password") },
        onValueChange = onPasswordChange,
        isError = isError
    )
}
