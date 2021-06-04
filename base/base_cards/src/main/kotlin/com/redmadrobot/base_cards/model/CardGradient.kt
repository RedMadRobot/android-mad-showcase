package com.redmadrobot.base_cards.model

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush

enum class CardGradient(val brush: Brush) {
    BLUE(
        Brush.linearGradient(
            colors = CardColors.BLUE.colors,
            start = Offset(0f, Float.POSITIVE_INFINITY),
            end = Offset(Float.POSITIVE_INFINITY, 0f)
        )
    ),

    RED(
        Brush.linearGradient(
            colors = CardColors.RED.colors,
            start = Offset(0f, Float.POSITIVE_INFINITY),
            end = Offset(Float.POSITIVE_INFINITY, 0f)
        )
    ),

    YELLOW(
        Brush.linearGradient(
            colors = CardColors.YELLOW.colors,
            start = Offset(0f, Float.POSITIVE_INFINITY),
            end = Offset(Float.POSITIVE_INFINITY, 0f)
        )
    ),

    PINK(
        Brush.linearGradient(
            colors = CardColors.PINK.colors,
            start = Offset(0f, Float.POSITIVE_INFINITY),
            end = Offset(Float.POSITIVE_INFINITY, 0f)
        )
    ),

    GREEN(
        Brush.linearGradient(
            colors = CardColors.GREEN.colors,
            start = Offset(0f, Float.POSITIVE_INFINITY),
            end = Offset(Float.POSITIVE_INFINITY, 0f)
        )
    )
}