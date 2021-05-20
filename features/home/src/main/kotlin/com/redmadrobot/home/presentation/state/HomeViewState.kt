package com.redmadrobot.home.presentation.state

import com.redmadrobot.core_presentation.model.State
import com.redmadrobot.home.presentation.model.CardViewInfoUi

data class HomeViewState(
   val cardsState: State<List<CardViewInfoUi>>,
)