package com.redmadrobot.details.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.redmadrobot.core_presentation.model.Content
import com.redmadrobot.core_presentation.model.Loading
import com.redmadrobot.core_presentation.model.Stub
import com.redmadrobot.details.presentation.view.CardDetailsView

@Composable
fun DetailsScreen(viewModel: DetailsViewModel) {
    when (val cardState = viewModel.viewState.collectAsState().value.card) {
        is Loading -> {
            Box(Modifier.fillMaxSize()) { CircularProgressIndicator(Modifier.align(Alignment.Center)) }
        }
        is Content -> {
            CardDetailsView(cardState = cardState.content)
        }
        is Stub -> {
            Column {
                Text(text = "error: ${cardState.error}", color = Color.White)
                Button(onClick = viewModel::onRetryClicked) {
                    Text("Try again", color = Color.White)
                }
            }
        }
    }
}


