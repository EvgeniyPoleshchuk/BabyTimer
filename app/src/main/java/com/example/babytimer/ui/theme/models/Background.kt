package com.example.babytimer.ui.theme.models

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

public val LocalBackground = compositionLocalOf<Background> { error("Not provided foreground") }


data class Background(
    val cardColor:Color,
    val mainBackground: Color,
)

val backgroundDark = Background(
    cardColor = Color(0xFF373844),
    mainBackground = Color(0xFF2A2A34)
)
val backgroundLight = Background(
    cardColor = Color(0xFFFFFFFF),
    mainBackground = Color(0xFFF9F9F9)
)