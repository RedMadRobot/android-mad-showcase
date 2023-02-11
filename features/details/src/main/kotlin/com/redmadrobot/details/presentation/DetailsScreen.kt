package com.redmadrobot.details.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.redmadrobot.base_cards.toCardViewState
import com.redmadrobot.core_network.CardDetailsQuery
import com.redmadrobot.core_presentation.model.Content
import com.redmadrobot.core_presentation.model.Loading
import com.redmadrobot.core_presentation.model.Stub
import com.redmadrobot.details.presentation.view.CreateCustomCard

@ExperimentalComposeUiApi
@Composable
fun DetailsRoute(viewModel: DetailsViewModel = hiltViewModel()) {
    val state = viewModel.viewState.collectAsState().value
    DetailsScreen(
        state, viewModel::onRetryClicked
    )
}

@ExperimentalComposeUiApi
@Composable
private fun DetailsScreen(
    state: DetailsViewState,
    onRetryClicked: () -> Unit,
) {
    when (state.card) {
        is Loading -> {
            Box(Modifier.fillMaxSize()) { CircularProgressIndicator(Modifier.align(Alignment.Center)) }
        }
        is Content -> {
            CreateCustomCard(state.card.content)
        }
        is Stub -> {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "error: ${state.card.error}",
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 14.dp)
                )
                Button(onClick = onRetryClicked) {
                    Text("Try again", color = Color.White)
                }
            }
        }
    }
}

@Preview(
    showBackground = true, backgroundColor = 0x434A74
)
@ExperimentalComposeUiApi
@Composable
fun PreviewDetailsScreenWithContent() {
    return DetailsScreen(
        DetailsViewState(
            card = Content(
                CardDetailsQuery.Card(
                    id = "33", number = "3123", type = "MASTER_CARD", color = "green"
                ).toCardViewState()
            ),
        )
    ) {}
}

@Preview(
    showBackground = true, backgroundColor = 0x434A74
)
@ExperimentalComposeUiApi
@Composable
fun PreviewDetailsScreenWithError() {
    return DetailsScreen(
        DetailsViewState(
            card = Stub(RuntimeException()),
        )
    ) {}
}


