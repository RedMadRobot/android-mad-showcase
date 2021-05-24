package com.redmadrobot.home.presentation.model

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

enum class CardBorderGradient(val brush: Brush) {
    BLUE(
        Brush.linearGradient(
            colors = listOf(
                Color(0xFFB4F4EF),
                Color(0xFF5959BA),
            ),
            start = Offset(0f, Float.POSITIVE_INFINITY),
            end = Offset(Float.POSITIVE_INFINITY, 0f)
        )
    ),

    RED(
        Brush.linearGradient(
            colors = listOf(
                Color(0xFFB88BDB),
                Color(0xFFCF5942)
            ),
            start = Offset(0f, 0f),
        )
    ),

    YELLOW(
        Brush.linearGradient(
            colors = listOf(
                Color(0xFFFFF8B6),
                Color(0xFFB15F13),
            ),
            start = Offset(0f, Float.POSITIVE_INFINITY),
            end = Offset(Float.POSITIVE_INFINITY, 0f)
        )
    ),

    PINK(
        Brush.linearGradient(
            colors = listOf(
                Color(0xFFCADFFF),
                Color(0xFF703AB5),
            ),
            start = Offset(0f, Float.POSITIVE_INFINITY),
            end = Offset(Float.POSITIVE_INFINITY, 0f)
        )
    ),

    GREEN(
        Brush.linearGradient(
            colors = listOf(
                Color(0xFFB6FDDC),
                Color(0xFF396466),
            ),
            start = Offset(0f, Float.POSITIVE_INFINITY),
            end = Offset(Float.POSITIVE_INFINITY, 0f)
        )
    )
}