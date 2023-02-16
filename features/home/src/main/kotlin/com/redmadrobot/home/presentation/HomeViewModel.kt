package com.redmadrobot.home.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.redmadrobot.base_cards.toCardViewState
import com.redmadrobot.core.extensions.safeLaunch
import com.redmadrobot.core_navigation.navigation.Router
import com.redmadrobot.core_navigation.navigation.screens.Routes
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
    private val api: ApolloApi,
    private val router: Router,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    companion object {
        private const val SCROLL_TO_LAST_POSITION_KEY = "SCROLL_TO_LAST_POSITION_KEY"
    }

    private val _viewState = MutableStateFlow<HomeViewState>(Loading())
    val viewState: StateFlow<HomeViewState> = _viewState

    // Fix negative arrangement: in initial state the list have a wrong position
    var scrollToLastPosition = savedStateHandle.get<Boolean>(SCROLL_TO_LAST_POSITION_KEY) ?: true
        private set

    init {
        loadCards()
    }

    fun onRetryClicked() = loadCards()

    fun onLastPositionScrolled() {
        savedStateHandle.set(SCROLL_TO_LAST_POSITION_KEY, false)
        scrollToLastPosition = false
    }

    private fun loadCards() {
        _viewState.update { Loading() }
        viewModelScope.safeLaunch(
            {
                val cards = api.query(CardsListQuery()).cards
                _viewState.update { Content(cards.map(CardsListQuery.Card::toCardViewState)) }
            },
            onError = { throwable ->
                _viewState.update { Stub(throwable) }
            }
        )
    }

    fun onCardClicked(id: String) {
        router.navigate(Routes.toDetails(id))
    }
}