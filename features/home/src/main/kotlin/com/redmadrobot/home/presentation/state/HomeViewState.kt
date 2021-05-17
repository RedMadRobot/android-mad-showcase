package com.redmadrobot.home.presentation.state

import com.redmadrobot.core_network.CardsListQuery.Card
import com.redmadrobot.core_presentation.model.State

data class HomeViewState(
   val title: String = "Cards List",
   val cardsState: State<List<Card>>,
   val cards: List<Card>? = null
)