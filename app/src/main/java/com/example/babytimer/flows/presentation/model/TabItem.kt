package com.example.babytimer.flows.presentation.model

import androidx.annotation.DrawableRes
import com.example.babytimer.R

data class TabItem(
    val title: String,
    @DrawableRes
    val unSelectedIcon: Int,
    val selectedIcon: Int
)

val tabList = listOf(
    TabItem(
        "Еда",
        unSelectedIcon = R.drawable.baseline_cookie_24,
        selectedIcon = R.drawable.baseline_cookie_24
    ),
    TabItem(
        "Сон",
        unSelectedIcon = R.drawable.baseline_bedroom_baby_24,
        selectedIcon = R.drawable.baseline_bedroom_baby_24,
    ),
)
