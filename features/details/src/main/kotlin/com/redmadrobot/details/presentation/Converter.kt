package com.redmadrobot.details.presentation

import androidx.compose.ui.graphics.Color
import com.redmadrobot.core.determineIcon
import com.redmadrobot.core.determineIconColor
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
        com.redmadrobot.core.PINK_COLOR -> CardColors.PINK.colors
        com.redmadrobot.core.BLUE_COLOR -> CardColors.BLUE.colors
        com.redmadrobot.core.RED_COLOR -> CardColors.RED.colors
        com.redmadrobot.core.YELLOW_COLOR -> CardColors.YELLOW.colors
        com.redmadrobot.core.GREEN_COLOR -> CardColors.GREEN.colors
        else -> CardColors.PINK.colors
    }
}

fun determineBorderCardColors(color: String):  List<Color>{
    return when (color) {
        com.redmadrobot.core.PINK_COLOR -> CardBorderColors.PINK.colors
        com.redmadrobot.core.BLUE_COLOR -> CardBorderColors.BLUE.colors
        com.redmadrobot.core.RED_COLOR -> CardBorderColors.RED.colors
        com.redmadrobot.core.YELLOW_COLOR -> CardBorderColors.YELLOW.colors
        com.redmadrobot.core.GREEN_COLOR -> CardBorderColors.GREEN.colors
        else -> CardColors.PINK.colors
    }
}


