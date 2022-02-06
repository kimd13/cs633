package edu.bu.authentication.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.bu.authentication.R

@Composable
fun AuthenticationBanner(
    title: String,
    description: String,
    @DrawableRes image: Int
) {
    val titleSize = 32.sp
    val descriptionSize = 16.sp
    val imageSize = 64.dp

    Row {
        Column {
            Text(
                text = title,
                fontSize = titleSize,
                fontWeight = FontWeight.ExtraBold
            )
            Text(
                text = description,
                fontSize = descriptionSize
            )
        }
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            Modifier.size(imageSize)
        )
    }
}

@Preview
@Composable
fun AuthenticationBannerPreview() {
    AuthenticationBanner(
        title = "Testing",
        description = "Testing",
        image = R.drawable.sign_in_image
    )
}