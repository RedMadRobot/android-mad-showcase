package com.redmadrobot.home.presentation

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.redmadrobot.base_cards.*
import com.redmadrobot.core_network.CardsListQuery.Card
import com.redmadrobot.home.presentation.model.*

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