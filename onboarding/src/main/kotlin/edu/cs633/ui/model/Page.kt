package edu.cs633.ui.model

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes

data class Page(
    @DrawableRes val image: Int,
    @ColorRes val backgroundColor: Int
)