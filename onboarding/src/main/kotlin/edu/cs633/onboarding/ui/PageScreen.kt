package edu.cs633.onboarding.ui

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import edu.cs633.onboarding.ui.model.Page

@Composable
internal fun PageScreen(page: Page) {
    Image(
        painter = painterResource(id = page.image),
        contentDescription = "page image"
    )
}