package edu.bu.authentication.ui

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun Link(
    text: String,
    size: TextUnit = 12.sp,
    sendTo: () -> Unit
) {
    Text(
        text = text,
        color = Color.Blue,
        fontSize = size,
        textDecoration = TextDecoration.Underline,
        modifier = Modifier
            .clickable { sendTo() }
    )
}