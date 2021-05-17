package com.redmadrobot.home.presentation

import CardGradient
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.redmadrobot.core.extensions.safeLaunch
import com.redmadrobot.core_network.ApolloApi
import com.redmadrobot.core_network.CardsListQuery
import com.redmadrobot.core_presentation.extensions.update
import com.redmadrobot.core_presentation.model.Content
import com.redmadrobot.core_presentation.model.Loading
import com.redmadrobot.core_presentation.model.Stub
import com.redmadrobot.home.presentation.state.HomeViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val api: ApolloApi
) : ViewModel() {

    private val _viewState = MutableStateFlow(HomeViewState(cardsState = Loading()))
    val viewState: StateFlow<HomeViewState> = _viewState

    private val swipeCards = mutableListOf<CardsListQuery.Card>()
    var isPressed = true

    init {
        loadCards()
    }

    fun onRetryClicked() = loadCards()

    private fun loadCards() {
        _viewState.update { copy(cardsState = Loading()) }
        viewModelScope.safeLaunch(
            {
                val cards = api.query(CardsListQuery()).cards
                _viewState.update { copy(cardsState = Content(cards)) }
                _viewState.update { copy(cards = cards) }
            },
            onError = { throwable ->
                _viewState.update { copy(cardsState = Stub(throwable)) }
            }
        )
    }

    fun onTouchUp(index: Int) {
        val lastIndex = _viewState.value.cards?.lastIndex
        val cards = _viewState.value.cards?.filterIndexed { i, _ ->
            i == lastIndex || i <= index
        }
        if (cards != null) {
            val removedItems = _viewState.value.cards?.filter { it !in cards }
            removedItems?.let { swipeCards.addAll(it) }
            _viewState.update {
                copy(cardsState = Content(cards))
            }
            _viewState.update { copy(cards = cards) }
        }
        isPressed = false
    }

    fun onTouchDown(index: Int) {
        val cards = _viewState.value.cards?.flatMapIndexed { i: Int, card: CardsListQuery.Card ->
            if (i == index) listOf(card) + swipeCards else listOf(card)
        }
        if (cards!=null) {
            swipeCards.clear()
            _viewState.update { copy(cardsState = Content(cards)) }
            _viewState.update { copy(cards = cards) }
        }
        isPressed = false
    }

    fun determineCardGradient(color: String): Brush {
        return when (color) {
            "pink" -> CardGradient.PINK.brush
            "blue" -> CardGradient.BLUE.brush
            "red" -> CardGradient.RED.brush
            "yellow" -> CardGradient.YELLOW.brush
            "green" -> CardGradient.GREEN.brush
            else -> CardGradient.YELLOW.brush
        }
    }

    fun determineIconColor(color: String): Color {
        return when (color) {
            "pink" -> Color(0xFF8D7CE7)
            "blue" -> Color(0xFF6D94DA)
            "red" -> Color(0xEECF5942)
            "yellow" -> Color(0xFFDB8A3F)
            "green" -> Color(0xFF539A83)
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
}