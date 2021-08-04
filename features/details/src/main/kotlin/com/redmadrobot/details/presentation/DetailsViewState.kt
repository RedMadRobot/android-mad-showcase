package com.redmadrobot.details.presentation

import com.redmadrobot.base_cards.model.CardViewState
import com.redmadrobot.core_presentation.model.State

data class DetailsViewState(
    val card: State<CardViewState>
)