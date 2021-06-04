package com.redmadrobot.base_cards.model

import androidx.compose.ui.graphics.Color

enum class CardColors(val colors: List<Color>) {
    BLUE(
        listOf(
            Color(0xFF91EAE4),
            Color(0xFF7F7FD5),
        )
    ),

    RED(
        listOf(
            Color(0xFFA36BCF),
            Color(0xFFE77557)
        )
    ),

    YELLOW(
        listOf(
            Color(0xFFF9ED80),
            Color(0xFFDF832E),
        )
    ),

    PINK(
        listOf(
            Color(0xFFB0D0FF),
            Color(0xFF914CE8),
        )
    ),

    GREEN(
        listOf(
            Color(0xFF99F2C8),
            Color(0xFF396063),
        )
    )

}