package com.example.babytimer.ui.theme

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ColumnScope.Gap(size: Int) = VerticalGap(size)

@Composable
fun RowScope.Gap(size: Int) = HorizontalGap(size)

@Composable
fun VerticalGap(size: Int) = Spacer(Modifier.height(size.dp))

@Composable
fun HorizontalGap(size: Int) = Spacer(Modifier.width(size.dp))