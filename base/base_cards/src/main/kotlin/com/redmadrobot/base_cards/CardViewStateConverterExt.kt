package com.redmadrobot.base_cards

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.redmadrobot.base_cards.model.*
import com.redmadrobot.core_network.CardDetailsQuery
import com.redmadrobot.core_network.CardsListQuery

// TODO: split two methods, and work with one data stucture by using fragments from appolo library

fun CardsListQuery.Card.toCardViewState(): CardViewState {
    return CardViewState(
        id = id,
        number = number,
        cardColors = toCardColors(color),
        cardBorderColors = toCardBorderCardColors(color),
        cardTextNumberColor = toCardTextNumberColor(color),
        cardGradient = toCardGradient(color),
        borderGradient = toCardBorderGradient(color),
        iconRes = toIconRes(type),
        iconColor = toIconColor(color),
    )
}

fun CardDetailsQuery.Card.toCardViewState(): CardViewState {
    return CardViewState(
        id = id,
        number = number,
        cardColors = toCardColors(color),
        cardBorderColors = toCardBorderCardColors(color),
        cardTextNumberColor = toCardTextNumberColor(color),
        cardGradient = toCardGradient(color),
        borderGradient = toCardBorderGradient(color),
        iconRes = toIconRes(type),
        iconColor = toIconColor(color),
    )
}

private const val PINK_COLOR = "pink"
private const val BLUE_COLOR = "blue"
private const val RED_COLOR = "red"
private const val YELLOW_COLOR = "yellow"
private const val GREEN_COLOR = "green"

private fun toIconColor(color: String): Color {
    return when (color) {
        PINK_COLOR -> Color(0xFF8D7CE7)
        BLUE_COLOR -> Color(0xFF6D94DA)
        RED_COLOR -> Color(0xEECF5942)
        YELLOW_COLOR -> Color(0xFFDB8A3F)
        GREEN_COLOR -> Color(0xFF539A83)
        else -> Color(0xFF539A83)
    }
}

private fun toIconRes(type: String): Int {
    return when (type) {
        "VISA" -> CardTypeIcon.VISA.icon
        "MASTER_CARD" -> CardTypeIcon.MASTERCARD.icon
        else -> CardTypeIcon.MASTERCARD.icon
    }
}

private fun toCardTextNumberColor(color: String): Color {
    return when (color) {
        PINK_COLOR -> CardTextNumberColor.PINK.color
        BLUE_COLOR -> CardTextNumberColor.BLUE.color
        RED_COLOR -> CardTextNumberColor.RED.color
        YELLOW_COLOR -> CardTextNumberColor.YELLOW.color
        GREEN_COLOR -> CardTextNumberColor.GREEN.color
        else -> CardTextNumberColor.PINK.color
    }
}

private fun toCardGradient(color: String): Brush {
    return when (color) {
        PINK_COLOR -> CardGradient.PINK.brush
        BLUE_COLOR -> CardGradient.BLUE.brush
        RED_COLOR -> CardGradient.RED.brush
        YELLOW_COLOR -> CardGradient.YELLOW.brush
        GREEN_COLOR -> CardGradient.GREEN.brush
        else -> CardGradient.YELLOW.brush
    }
}

private fun toCardBorderGradient(color: String): Brush {
    return when (color) {
        PINK_COLOR -> CardBorderGradient.PINK.brush
        BLUE_COLOR -> CardBorderGradient.BLUE.brush
        RED_COLOR -> CardBorderGradient.RED.brush
        YELLOW_COLOR -> CardBorderGradient.YELLOW.brush
        GREEN_COLOR -> CardBorderGradient.GREEN.brush
        else -> CardBorderGradient.YELLOW.brush
    }
}

private fun toCardColors(color: String): List<Color> {
    return when (color) {
        PINK_COLOR -> CardColors.PINK.colors
        BLUE_COLOR -> CardColors.BLUE.colors
        RED_COLOR -> CardColors.RED.colors
        YELLOW_COLOR -> CardColors.YELLOW.colors
        GREEN_COLOR -> CardColors.GREEN.colors
        else -> CardColors.PINK.colors
    }
}

private fun toCardBorderCardColors(color: String): List<Color> {
    return when (color) {
        PINK_COLOR -> CardBorderColors.PINK.colors
        BLUE_COLOR -> CardBorderColors.BLUE.colors
        RED_COLOR -> CardBorderColors.RED.colors
        YELLOW_COLOR -> CardBorderColors.YELLOW.colors
        GREEN_COLOR -> CardBorderColors.GREEN.colors
        else -> CardColors.PINK.colors
    }
}
