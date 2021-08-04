package com.redmadrobot.base_cards.model

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

data class CardViewState(
    val id: String,
    val number: String,
    val cardColors: List<Color>,
    val cardBorderColors: List<Color>,
    val cardTextNumberColor: Color,
    val cardGradient: Brush,
    val borderGradient: Brush,
    val iconRes: Int,
    val iconColor: Color,
)