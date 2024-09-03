package com.erdem.projecthomework

import androidx.annotation.DrawableRes

data class Game (@DrawableRes val imageResource:Int,
                 val name: String,
                 val gameType: String,
                 val info: String,
                 val metaPoint: Int,
)