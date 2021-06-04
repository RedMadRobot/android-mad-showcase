package com.redmadrobot.details.presentation

import androidx.compose.ui.graphics.Color
import com.redmadrobot.base_cards.*
import com.redmadrobot.core_network.CardDetailsQuery
import com.redmadrobot.details.presentation.model.CardBorderColors
import com.redmadrobot.details.presentation.model.CardColors
import com.redmadrobot.details.presentation.model.CardDetailsUi

fun CardDetailsQuery.Card.toCardDetailsUi(): CardDetailsUi {
    return CardDetailsUi(
        id = id,
        number = number,
        cardColors = determineCardColors(color),
        cardBorderColors = determineBorderCardColors(color),
        iconRes = determineIcon(type),
        iconColor = determineIconColor(color)
    )
}

fun determineCardColors(color: String):  List<Color>{
    return when (color) {
        PINK_COLOR -> CardColors.PINK.colors
        BLUE_COLOR -> CardColors.BLUE.colors
        RED_COLOR -> CardColors.RED.colors
        YELLOW_COLOR -> CardColors.YELLOW.colors
        GREEN_COLOR -> CardColors.GREEN.colors
        else -> CardColors.PINK.colors
    }
}

fun determineBorderCardColors(color: String):  List<Color>{
    return when (color) {
        PINK_COLOR -> CardBorderColors.PINK.colors
        BLUE_COLOR -> CardBorderColors.BLUE.colors
        RED_COLOR -> CardBorderColors.RED.colors
        YELLOW_COLOR -> CardBorderColors.YELLOW.colors
        GREEN_COLOR -> CardBorderColors.GREEN.colors
        else -> CardColors.PINK.colors
    }
}


