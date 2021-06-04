package com.redmadrobot.details.presentation

import com.redmadrobot.core_presentation.model.State
import com.redmadrobot.details.presentation.model.CardDetailsUi

data class DetailsViewState(
    val cardDetailsState: State<CardDetailsUi>,
)