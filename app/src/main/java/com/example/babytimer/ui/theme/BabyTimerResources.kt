package com.example.babytimer.ui.theme

import androidx.compose.runtime.Composable
import com.example.babytimer.ui.theme.models.LocalBackground
import com.example.babytimer.ui.theme.models.LocalForeground
import com.example.babytimer.ui.theme.models.LocalTypography

object BabyTimerResources {
    val background
        @Composable get() = LocalBackground.current

    val foreGround
        @Composable get() = LocalForeground.current

    val typography
        @Composable get() = LocalTypography.current
}