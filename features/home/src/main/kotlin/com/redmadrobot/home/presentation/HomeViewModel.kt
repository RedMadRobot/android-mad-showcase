package com.redmadrobot.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavType
import androidx.navigation.compose.navArgument
import com.redmadrobot.core.extensions.safeLaunch
import com.redmadrobot.core_navigation.navigation.Router
import com.redmadrobot.core_navigation.navigation.screens.Screens
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
) : ViewModel() {

    private val _viewState = MutableStateFlow(HomeViewState(cardsState = Loading()))
    val viewState: StateFlow<HomeViewState> = _viewState

    init {
        loadCards()
    }

    fun onRetryClicked() = loadCards()

    private fun loadCards() {
        _viewState.update { copy(cardsState = Loading()) }
        viewModelScope.safeLaunch(
            {
                val cards = api.query(CardsListQuery()).cards
                _viewState.update { copy(cardsState = Content(cards.map {it.toCardViewInfoUi()})) }
            },
            onError = { throwable ->
                _viewState.update { copy(cardsState = Stub(throwable)) }
            }
        )
    }

    fun navigateToDetails(id: String) {
        router.navigate(Screens.details(id))
    }
}