package com.redmadrobot.home.presentation

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.redmadrobot.core_network.CardsListQuery.Card
import com.redmadrobot.home.presentation.model.*

const val PINK_COLOR = "pink"
const val BLUE_COLOR = "blue"
const val RED_COLOR = "red"
const val YELLOW_COLOR = "yellow"
const val GREEN_COLOR = "green"

fun Card.toCardViewInfoUi(): CardViewInfoUi {
    return CardViewInfoUi(
        id = id,
        number = number,
        textNumberColor = determineTextNumberColor(color),
        cardGradient = determineCardGradient(color),
        cardBorderGradient = determineCardBorderGradient(color),
        iconRes = determineIcon(type),
        iconColor = determineIconColor(color)
    )
}

fun determineTextNumberColor(color: String): Color {
    return when (color) {
        PINK_COLOR -> TextNumberColor.PINK.color
        BLUE_COLOR -> TextNumberColor.BLUE.color
        RED_COLOR -> TextNumberColor.RED.color
        YELLOW_COLOR -> TextNumberColor.YELLOW.color
        GREEN_COLOR -> TextNumberColor.GREEN.color
        else -> TextNumberColor.PINK.color
    }
}

fun determineCardGradient(color: String): Brush {
    return when (color) {
        PINK_COLOR -> CardGradient.PINK.brush
        BLUE_COLOR -> CardGradient.BLUE.brush
        RED_COLOR -> CardGradient.RED.brush
        YELLOW_COLOR -> CardGradient.YELLOW.brush
        GREEN_COLOR -> CardGradient.GREEN.brush
        else -> CardGradient.YELLOW.brush
    }
}

fun determineCardBorderGradient(color: String): Brush {
    return when (color) {
        PINK_COLOR -> CardBorderGradient.PINK.brush
        BLUE_COLOR -> CardBorderGradient.BLUE.brush
        RED_COLOR -> CardBorderGradient.RED.brush
        YELLOW_COLOR -> CardBorderGradient.YELLOW.brush
        GREEN_COLOR -> CardBorderGradient.GREEN.brush
        else -> CardBorderGradient.YELLOW.brush
    }
}

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