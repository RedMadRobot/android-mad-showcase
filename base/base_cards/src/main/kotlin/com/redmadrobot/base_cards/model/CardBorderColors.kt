package com.redmadrobot.base_cards.model

import androidx.compose.ui.graphics.Color

enum class CardBorderColors(val colors: List<Color>) {
    BLUE(
        listOf(
            Color(0xFFB4F4EF),
            Color(0xFF5959BA),
        )
    ),

    RED(
        listOf(
            Color(0xFFB88BDB),
            Color(0xFFCF5942)
        )
    ),

    YELLOW(
        listOf(
            Color(0xFFFFF8B6),
            Color(0xFFB15F13),
        )
    ),

    PINK(
        listOf(
            Color(0xFFCADFFF),
            Color(0xFF703AB5),
        )
    ),

    GREEN(
        listOf(
            Color(0xFFB6FDDC),
            Color(0xFF396466),
        )
    )
}