package com.example.babytimer.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.example.babytimer.ui.theme.models.Background
import com.example.babytimer.ui.theme.models.Foreground
import com.example.babytimer.ui.theme.models.LocalBackground
import com.example.babytimer.ui.theme.models.LocalForeground
import com.example.babytimer.ui.theme.models.LocalTypography
import com.example.babytimer.ui.theme.models.Typography
import com.example.babytimer.ui.theme.models.backgroundDark
import com.example.babytimer.ui.theme.models.backgroundLight
import com.example.babytimer.ui.theme.models.foregroundDark
import com.example.babytimer.ui.theme.models.foregroundLight

@Composable
fun BabyTimeTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val background: Background
    val foreground: Foreground
    val typography: Typography = Typography()

    if (isDarkTheme) {
        background = backgroundDark
        foreground = foregroundDark
    } else {
        background = backgroundLight
        foreground = foregroundLight
    }

    CompositionLocalProvider(
        LocalBackground provides background,
        LocalForeground provides foreground,
        LocalTypography provides typography
        ) {
        MaterialTheme(
            colorScheme = colorScheme,
            content = content
        )

    }

}

