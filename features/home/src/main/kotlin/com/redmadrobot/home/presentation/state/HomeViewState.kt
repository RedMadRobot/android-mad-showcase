package com.redmadrobot.home.presentation.state

import com.redmadrobot.core_presentation.model.State
import com.redmadrobot.base_cards.model.CardViewState

data class HomeViewState(
    val cards: State<List<CardViewState>>,
)