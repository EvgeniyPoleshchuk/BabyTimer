package com.example.babytimer.ui.theme.models

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

val LocalTypography = staticCompositionLocalOf<Typography> { error("Not provided typography") }

data class Typography(
    val header: Header = Header(),
    val body: Body = Body(),
    val footer: Footer = Footer(),
)

val textAlign = TextAlign.Center
val baseLineShift = BaselineShift.None

data class Header(
    val giantSemibold: TextStyle = TextStyle(
        textAlign = textAlign,
        fontSize = 48.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = FontFamily.Default,
        baselineShift = baseLineShift,
    ),
    val largeBoldRounded: TextStyle = TextStyle(
        textAlign = textAlign,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Default,
        baselineShift = baseLineShift,
    ),
    val largeBold: TextStyle = TextStyle(
        textAlign = textAlign,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Default,
        baselineShift = baseLineShift,
    ),
    val mediumBold: TextStyle = TextStyle(
        textAlign = textAlign,
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Default,
        baselineShift = baseLineShift,
    ),
    val smallBold: TextStyle = TextStyle(
        textAlign = textAlign,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Default,
        baselineShift = baseLineShift,
    ),
)

data class Body(
    val large: TextStyle = TextStyle(
        textAlign = textAlign,
        fontSize = 17.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = FontFamily.Default,
        baselineShift = baseLineShift,
    ),
    val largeNormal: TextStyle = TextStyle(
        textAlign = textAlign,
        fontSize = 17.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily.Default,
        baselineShift = baseLineShift,
    ),
    val largeBold: TextStyle = TextStyle(
        textAlign = textAlign,
        fontSize = 17.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Default,
        baselineShift = baseLineShift,
    ),
    val largeSemiBold: TextStyle = TextStyle(
        textAlign = textAlign,
        fontSize = 17.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = FontFamily.Default,
        baselineShift = baseLineShift,
    ),
    val medium: TextStyle = TextStyle(
        textAlign = textAlign,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily.Default,
        baselineShift = baseLineShift,
    ),
    val mediumBold: TextStyle = TextStyle(
        textAlign = textAlign,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = FontFamily.Default,
        baselineShift = baseLineShift,
    ),
    val small: TextStyle = TextStyle(
        textAlign = textAlign,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily.Default,
        baselineShift = baseLineShift,
    ),
    val smallBold: TextStyle = TextStyle(
        textAlign = textAlign,
        fontSize = 15.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = FontFamily.Default,
        baselineShift = baseLineShift,
    ),
)

data class Footer(
    val medium: TextStyle = TextStyle(
        textAlign = textAlign,
        fontSize = 13.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily.Default,
        baselineShift = baseLineShift,
    ),
    val small: TextStyle = TextStyle(
        textAlign = textAlign,
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily.Default,
        baselineShift = baseLineShift,
    ),
)