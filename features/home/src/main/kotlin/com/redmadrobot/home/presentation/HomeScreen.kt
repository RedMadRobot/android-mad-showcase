package com.redmadrobot.home.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.redmadrobot.core_presentation.model.Content
import com.redmadrobot.core_presentation.model.Loading
import com.redmadrobot.core_presentation.model.Stub
import com.redmadrobot.home.presentation.view.CardView

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val viewState = viewModel.viewState.collectAsState().value
    when (val cardsState = viewState.cardsState) {
        is Loading -> {
            Box {
               CircularProgressIndicator(Modifier.align(Alignment.Center))
            }
        }
        is Content -> {
            val cards = cardsState.content
            LazyColumn(
                modifier = Modifier
                    .background(Color(0xFF434A74))
                    .clip(RoundedCornerShape(10.dp)),
                reverseLayout = true,
                verticalArrangement = Arrangement.spacedBy((-90).dp)
            ) {
                items(count = cards.size) { cardIndex ->
                    val card = cards[cardIndex]
                    CardView(item = card)
                }
            }
        }
        is Stub -> {
            Column {
                Text(text = "error: ${cardsState.error}", color = Color.White)
                Button(onClick = viewModel::onRetryClicked) {
                    Text("Try again", color = Color.White)
                }
            }
        }
    }
}