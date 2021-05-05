package com.redmadrobot.home.presentation

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

    init {
        loadCards()
    }

    private fun loadCards() {
        _viewState.update { copy(cardsState = Loading()) }
        viewModelScope.safeLaunch(
            {
                val cards = api.query(CardsListQuery()).cards!!.mapNotNull { it!! } // TODO remove nulls
                _viewState.update { copy(cardsState = Content(cards)) }
            },
            onError = { throwable ->
                _viewState.update { copy(cardsState = Stub(throwable)) }
            }
        )
    }
}