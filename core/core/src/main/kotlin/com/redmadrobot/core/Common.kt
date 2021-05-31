package com.redmadrobot.core

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.redmadrobot.core.model.CardBorderGradient
import com.redmadrobot.core.model.CardGradient
import com.redmadrobot.core.model.TypeIconCard

const val PINK_COLOR = "pink"
const val BLUE_COLOR = "blue"
const val RED_COLOR = "red"
const val YELLOW_COLOR = "yellow"
const val GREEN_COLOR = "green"

fun determineIconColor(color: String): Color {
    return when (color) {
        PINK_COLOR -> Color(0xFF8D7CE7)
        BLUE_COLOR -> Color(0xFF6D94DA)
        RED_COLOR -> Color(0xEECF5942)
        YELLOW_COLOR -> Color(0xFFDB8A3F)
        GREEN_COLOR -> Color(0xFF539A83)
        else -> Color(0xFF539A83)
    }
}

fun determineIcon(type: String): Int {
    return when (type) {
        "VISA" -> TypeIconCard.VISA.icon
        "MASTER_CARD" -> TypeIconCard.MASTERCARD.icon
        else -> TypeIconCard.MASTERCARD.icon
    }
}