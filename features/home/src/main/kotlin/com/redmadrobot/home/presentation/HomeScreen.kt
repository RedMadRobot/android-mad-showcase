package com.redmadrobot.home.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.redmadrobot.base_cards.toCardViewState
import com.redmadrobot.core_network.CardDetailsQuery.Card
import com.redmadrobot.core_presentation.model.Content
import com.redmadrobot.core_presentation.model.Loading
import com.redmadrobot.core_presentation.model.Stub
import com.redmadrobot.home.presentation.state.HomeViewState
import com.redmadrobot.home.presentation.view.CardView

@Composable
fun HomeRoute(viewModel: HomeViewModel = hiltViewModel()) {
    val state = viewModel.viewState.collectAsState().value
    HomeScreen(
        state,
        viewModel.scrollToLastPosition,
        viewModel::onCardClicked,
        viewModel::onRetryClicked,
        viewModel::onLastPositionScrolled,
    )
}

@Composable
fun HomeScreen(
    state: HomeViewState,
    scrollToLastPosition: Boolean,
    onCardClicked: (String) -> Unit,
    onRetryClicked: () -> Unit,
    onLastPositionScrolled: () -> Unit,
) {
    when (state.state) {
        is Loading -> {
            Box(Modifier.fillMaxSize()) { CircularProgressIndicator(Modifier.align(Alignment.Center)) }
        }
        is Content -> {
            val cards = state.state.content
            val listState = rememberLazyListState()
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 14.dp)
                    .background(Color(0xFF434A74))
                    .clip(RoundedCornerShape(10.dp)),
                reverseLayout = true,
                verticalArrangement = Arrangement.spacedBy((-90).dp),
                state = listState,
            ) {
                items(count = cards.size) { cardIndex ->
                    CardView(
                        cardViewState = cards[cardIndex], onCardClicked = onCardClicked
                    )
                }
            }
            LaunchedEffect(scrollToLastPosition) {
                listState.scrollToItem(cards.size - 1)
                onLastPositionScrolled()
            }
        }
        is Stub -> {
            Column {
                Text(text = "error: ${state.state.error}", color = Color.White)
                Button(onClick = onRetryClicked) {
                    Text("Try again", color = Color.White)
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenContent() {
    HomeScreen(
        HomeViewState(
            Content(
                listOf(
                    Card(
                        id = "2", number = "3123", type = "MASTER_CARD", color = "green"
                    ).toCardViewState(),
                    Card(
                        id = "1", number = "1111", type = "VISA", color = "blue"
                    ).toCardViewState()
                )
            )
        ),
        scrollToLastPosition = false,
        onCardClicked = {},
        onRetryClicked = {},
        onLastPositionScrolled = {},
    )
}