package com.onurbalci.infoproject

import androidx.annotation.DrawableRes

data class Footballer(
    @DrawableRes val imageResource: Int,
    val name: String,
    val info: String,
    val resAreas: List<String>
)
