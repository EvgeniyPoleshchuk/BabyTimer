package com.example.babytimer.ui.theme.models

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

public val LocalForeground = compositionLocalOf<Foreground> { error("Not provided foreground") }


data class Foreground(
    val base:Color
)

val foregroundLight = Foreground(
    base = Color(0xFF1B1B22)
)
val foregroundDark = Foreground(
    base = Color(0xFFFFFFFF)
)