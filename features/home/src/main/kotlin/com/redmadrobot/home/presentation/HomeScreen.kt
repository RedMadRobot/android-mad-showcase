package com.redmadrobot.home.presentation

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.redmadrobot.core_network.CardsListQuery.Card
import com.redmadrobot.core_presentation.model.Content
import com.redmadrobot.core_presentation.model.Loading
import com.redmadrobot.core_presentation.model.State
import com.redmadrobot.core_presentation.model.Stub
import com.redmadrobot.home.R
import kotlin.math.roundToInt
import kotlin.math.sign

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val viewState = viewModel.viewState.collectAsState().value
    Column {
        Text(text = viewState.title, color = Color.White)
        CardsList(viewState.cardsState, viewModel = viewModel) { viewModel.onRetryClicked() }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
private fun CardContent(item: Card, viewModel: HomeViewModel, cardIndex: Int) {
    val height = 200.dp
    val context = LocalContext.current
    val cardBackground = viewModel.determineCardGradient(item.color)
    val iconTint = viewModel.determineIconColor(item.color)
    val icon = viewModel.determineIcon(item.type)
    var isPressed by remember { mutableStateOf(true) }
    var newValue: Int
    var offsetY by remember { mutableStateOf(0f) }
    Column(
        Modifier
            .offset { IntOffset(0, offsetY.roundToInt()) }
            .padding(10.dp)
            .draggable(
                orientation = Orientation.Vertical,
                state = rememberDraggableState { delta ->
                    if (isPressed) {
                        val summed = delta + offsetY
                        newValue = summed.coerceIn(-1f, 1f).roundToInt()
                        if (offsetY.sign > 0 && offsetY == 20f) {
                            viewModel.onTouchDown(cardIndex)
                        } else if (offsetY.sign < 0 && offsetY == -20f) {
                            viewModel.onTouchUp(cardIndex)
                        }
                        offsetY += newValue
                    }
                },
                onDragStopped = {
                    isPressed = false
                    newValue = 0
                    offsetY = 0f
                },
                onDragStarted = {
                    isPressed = true
                }
            )
            .clickable {
                Toast
                    .makeText(context, "Number: ${item.number}", Toast.LENGTH_SHORT)
                    .show()
            }
            .fillMaxWidth()
            .height(height)
            .clip(RoundedCornerShape(10.dp))
            .background(cardBackground)
    ) {
        Icon(
            modifier = Modifier
                .padding(30.dp),
            painter = painterResource(id = R.drawable.ic_subtract),
            contentDescription = "substract",
            tint = iconTint,
        )
        Row(
            Modifier
                .padding(30.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = item.number, color = Color.White)
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "type",
                tint = iconTint
            )
        }
    }

}

@Composable
private fun CardsList(
    cardsState: State<List<Card>>,
    viewModel: HomeViewModel,
    onRetryClickListener: () -> Unit,
) {
    when (cardsState) {
        is Loading -> {
            CircularProgressIndicator()
        }
        is Content -> {
            val cards = cardsState.content
            LazyColumn(reverseLayout = true, verticalArrangement = Arrangement.spacedBy(-138.dp)) {
                items(count = cards.size) { cardIndex ->
                    val card = cards[cardIndex]
                    CardContent(item = card, viewModel = viewModel, cardIndex = cardIndex)
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