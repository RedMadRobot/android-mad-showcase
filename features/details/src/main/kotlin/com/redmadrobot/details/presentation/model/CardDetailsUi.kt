package com.redmadrobot.details.presentation.model

import androidx.compose.ui.graphics.Color

data class CardDetailsUi(
    val id: String,
    val number: String,
    val cardColors: List<Color>,
    val cardBorderColors: List<Color>,
    val iconRes: Int,
    val iconColor: Color
)

