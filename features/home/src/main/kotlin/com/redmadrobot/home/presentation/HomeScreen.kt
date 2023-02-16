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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.redmadrobot.base_cards.model.CardViewState
import com.redmadrobot.core_presentation.model.Content
import com.redmadrobot.core_presentation.model.Loading
import com.redmadrobot.core_presentation.model.Stub
import com.redmadrobot.home.presentation.view.CardView

@Composable
fun HomeRoute() {
    val viewModel: HomeViewModel = hiltViewModel()
    HomeScreen(viewModel)
}

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    when (val state = viewModel.viewState.collectAsStateWithLifecycle().value) {
        is Loading -> {
            Box(Modifier.fillMaxSize()) { CircularProgressIndicator(Modifier.align(Alignment.Center)) }
        }
        is Content -> {
            val cards: List<CardViewState> = state.content
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
                        cardViewState = cards[cardIndex], onCardClicked = viewModel::onCardClicked
                    )
                }
            }
            LaunchedEffect(viewModel.scrollToLastPosition) {
                listState.scrollToItem(cards.size - 1)
                viewModel.onLastPositionScrolled()
            }
        }
        is Stub -> {
            Column {
                Text(text = "error: ${state.error}", color = Color.White)
                Button(onClick = viewModel::onRetryClicked) {
                    Text("Try again", color = Color.White)
                }
            }
        }
    }
}