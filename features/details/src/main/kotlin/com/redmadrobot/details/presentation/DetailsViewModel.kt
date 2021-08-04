package com.redmadrobot.details.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.redmadrobot.base_cards.toCardViewState
import com.redmadrobot.core.extensions.safeLaunch
import com.redmadrobot.core_network.ApolloApi
import com.redmadrobot.core_network.CardDetailsQuery
import com.redmadrobot.core_presentation.extensions.update
import com.redmadrobot.core_presentation.model.Content
import com.redmadrobot.core_presentation.model.Loading
import com.redmadrobot.core_presentation.model.Stub
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val api: ApolloApi,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _viewState = MutableStateFlow(DetailsViewState(card = Loading()))
    val viewState: StateFlow<DetailsViewState> = _viewState
    private val id = savedStateHandle.get<String>("id")!!

    init {
        loadDetails()
    }

    fun onRetryClicked() = loadDetails()

    private fun loadDetails() {
        _viewState.update { copy(card = Loading()) }
        viewModelScope.safeLaunch(
            {
                val card = api.query(CardDetailsQuery(id = id)).card
                _viewState.update { copy(card = Content(card.toCardViewState())) }
            },
            onError = { throwable ->
                _viewState.update { copy(card = Stub(throwable)) }
            }
        )
    }
}