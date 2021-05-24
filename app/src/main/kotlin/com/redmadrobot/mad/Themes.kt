package com.redmadrobot.mad

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val lightThemeColors
    get() = lightColors(
        primary = Primary,
        onPrimary = Color.White
    )

val Primary = Color(0xFF3E3058)

@Composable
fun AppTheme(content: @Composable () -> Unit) = MaterialTheme(colors = lightThemeColors, content = content)