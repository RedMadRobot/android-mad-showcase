package com.redmadrobot.home.presentation.model

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

data class CardViewInfoUi(
    val id: String,
    val number: String,
    val textNumberColor: Color,
    val cardGradient: Brush,
    val cardBorderGradient: Brush,
    val iconRes: Int,
    val iconColor: Color
)