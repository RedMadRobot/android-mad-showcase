package com.redmadrobot.home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.Color
import com.redmadrobot.core_network.CardsListQuery.Card
import com.redmadrobot.core_presentation.model.Content
import com.redmadrobot.core_presentation.model.Loading
import com.redmadrobot.core_presentation.model.State
import com.redmadrobot.core_presentation.model.Stub

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val viewState = viewModel.viewState.collectAsState().value
    Column {
        Text(text = viewState.title, color = Color.White)
        CardsList(viewState.cardsState) { viewModel.onRetryClicked() }
    }
}

@Composable
private fun CardsList(
    cardsState: State<List<Card>>,
    onRetryClickListener: () -> Unit,
) {
    when (cardsState) {
        is Loading -> {
            CircularProgressIndicator()
        }
        is Content -> {
            val cards = cardsState.content
            LazyColumn {
                items(count = cards.size) { cardIndex ->
                    val card = cards[cardIndex]
                    Text(text = card.number, color = Color.White)
                }
            }
        }
        is Stub -> {
            Column {
                Text(text = "error: ${cardsState.error}", color = Color.White)
                Button(onClick = onRetryClickListener) {
                    Text("Try again", color = Color.White)
                }
            }
        }
    }
}