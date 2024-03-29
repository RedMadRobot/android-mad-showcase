package com.redmadrobot.home.presentation.view

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.redmadrobot.base_cards.model.CardViewState
import com.redmadrobot.home.R

@SuppressLint("UnrememberedMutableState")
@Composable
fun CardView(cardViewState: CardViewState, onCardClicked: (String) -> Unit) {
    val height = 200.dp
    Column(
        Modifier
            .padding(horizontal = 10.dp, vertical = 10.dp)
            .drawColoredShadow(
                Color.White,
                darkColor = Color.Black,
                borderRadius = 10.dp,
                offsetY = 0.dp,
                offsetX = 0.dp,
                offsetDarkY = 10.dp
            )
            .clickable {
                onCardClicked(cardViewState.id)
            }
            .fillMaxWidth()
            .height(height)
            .clip(RoundedCornerShape(10.dp))
            .background(cardViewState.cardGradient)
            .border(BorderStroke(1.dp, cardViewState.borderGradient), RoundedCornerShape(10.dp))
    ) {
        Icon(
            modifier = Modifier
                .padding(30.dp),
            painter = painterResource(id = R.drawable.ic_subtract),
            contentDescription = "substract",
            tint = cardViewState.iconColor,
        )
        Spacer(modifier = Modifier.height(40.dp))
        Row(
            Modifier
                .padding(horizontal = 30.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.Bottom)
                    .drawTextColoredShadow(
                        shadowColor = Color.White,
                        textColor = cardViewState.iconColor,
                        text = cardViewState.number
                    ), color = Color.Black, text = ""
            )
            Icon(
                modifier = Modifier.align(Alignment.Bottom),
                painter = painterResource(id = cardViewState.iconRes),
                contentDescription = "type",
                tint = cardViewState.iconColor
            )
        }
    }
}

private fun Modifier.drawTextColoredShadow(
    shadowColor: Color,
    textColor: Color,
    alpha: Float = 0.8f,
    shadowRadius: Float = 5f,
    offsetY: Float = 3f,
    offsetX: Float = 3f,
    text: String
) = this.drawBehind {
    val shadowColorArgb =
        android.graphics.Color.toArgb(shadowColor.copy(alpha = alpha).value.toLong())
    val textColorArgb = android.graphics.Color.toArgb(textColor.value.toLong())

    drawIntoCanvas {
        val paint = Paint()
        val frameworkPaint = paint.asFrameworkPaint()
        frameworkPaint.isAntiAlias = true
        frameworkPaint.color = textColorArgb
        frameworkPaint.textSize = 50f
        frameworkPaint.setShadowLayer(
            shadowRadius,
            offsetX,
            offsetY,
            shadowColorArgb
        )
        it.nativeCanvas.drawText(text, 0f, this.size.height, frameworkPaint)
    }
}

private fun Modifier.drawColoredShadow(
    color: Color,
    darkColor: Color,
    alpha: Float = 0.2f,
    borderRadius: Dp = 20.dp,
    shadowRadius: Dp = 10.dp,
    offsetY: Dp = 0.dp,
    offsetX: Dp = 0.dp,
    offsetDarkY: Dp = 0.dp,
    offsetDarkX: Dp = 0.dp
) = this.drawBehind {
    val transparentColor = android.graphics.Color.toArgb(color.copy(alpha = 0.0f).value.toLong())

    val shadowColor = android.graphics.Color.toArgb(color.copy(alpha = alpha).value.toLong())
    val shadowDarkColor =
        android.graphics.Color.toArgb(darkColor.copy(alpha = alpha).value.toLong())
    this.drawIntoCanvas {
        val paint = Paint()
        val frameworkPaint = paint.asFrameworkPaint()
        frameworkPaint.color = transparentColor
        frameworkPaint.setShadowLayer(
            shadowRadius.toPx(),
            offsetX.toPx(),
            offsetY.toPx(),
            shadowColor
        )
        it.drawRoundRect(
            0f,
            0f,
            this.size.width - 2 * shadowRadius.value,
            this.size.height - 2 * shadowRadius.value,
            borderRadius.toPx(),
            borderRadius.toPx(),
            paint
        )
        val darkPaint = Paint()
        val frameworkDarkPaint = darkPaint.asFrameworkPaint()
        frameworkDarkPaint.setShadowLayer(
            shadowRadius.toPx(),
            offsetDarkX.toPx(),
            offsetDarkY.toPx(),
            shadowDarkColor
        )
        it.drawRoundRect(
            2 * shadowRadius.value,
            0f,
            this.size.width - 2 * shadowRadius.value,
            this.size.height,
            borderRadius.toPx(),
            borderRadius.toPx(),
            darkPaint
        )
    }
}