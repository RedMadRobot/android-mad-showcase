package com.redmadrobot.core.model

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

enum class CardGradient(val brush: Brush) {
    BLUE(
        Brush.linearGradient(
            colors = listOf(
                Color(0xFF91EAE4),
                Color(0xFF86A8E7),
                Color(0xFF7F7FD5),
            ),
            start = Offset(0f, Float.POSITIVE_INFINITY),
            end = Offset(Float.POSITIVE_INFINITY, 0f)
        )
    ),

    RED(
        Brush.linearGradient(
            colors = listOf(
                Color(0xFFA36BCF),
                Color(0xFFE77557)
            ),
            start = Offset(0f, Float.POSITIVE_INFINITY),
            end = Offset(Float.POSITIVE_INFINITY, 0f)
        )
    ),

    YELLOW(
        Brush.linearGradient(
            colors = listOf(
                Color(0xFFF9ED80),
                Color(0xFFDF832E),
            ),
            start = Offset(0f, Float.POSITIVE_INFINITY),
            end = Offset(Float.POSITIVE_INFINITY, 0f)
        )
    ),

    PINK(
        Brush.linearGradient(
            colors = listOf(
                Color(0xFFB0D0FF),
                Color(0xFF914CE8),
            ),
            start = Offset(0f, Float.POSITIVE_INFINITY),
            end = Offset(Float.POSITIVE_INFINITY, 0f)
        )
    ),

    GREEN(
        Brush.linearGradient(
            colors = listOf(
                Color(0xFF99F2C8),
                Color(0xFF396063),
            ),
            start = Offset(0f, Float.POSITIVE_INFINITY),
            end = Offset(Float.POSITIVE_INFINITY, 0f)
        )
    )
}