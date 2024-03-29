package com.redmadrobot.details.presentation.view

import android.annotation.SuppressLint
import android.graphics.*
import android.text.TextPaint
import android.view.MotionEvent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.drawable.toBitmap
import com.redmadrobot.base_cards.model.CardViewState
import com.redmadrobot.details.R
import com.redmadrobot.details.presentation.model.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect

@ExperimentalComposeUiApi
@SuppressLint("UseCompatLoadingForDrawables")
@Composable
fun CreateCustomCard(
    card: CardViewState
) {
    val imageSize = with(LocalDensity.current) { 150.dp.toPx() }.toInt()
    val cardIconWidth = with(LocalDensity.current) { 70.dp.toPx() }.toInt()
    val cardIconHeight = with(LocalDensity.current) { 40.dp.toPx() }.toInt()
    val circleIconWidth = with(LocalDensity.current) { 10.dp.toPx() }.toInt()
    val circleIconHeight = with(LocalDensity.current) { 24.dp.toPx() }.toInt()
    val innerMaskImageHeight = with(LocalDensity.current) { 90.dp.toPx() }.toInt()
    val innerMaskImageWidth = with(LocalDensity.current) { 80.dp.toPx() }.toInt()
    val leftMargin = with(LocalDensity.current) { 20.dp.toPx() }
    val imageRadius = with(LocalDensity.current) { 50.dp.toPx() }
    val imageCxCoordinate = with(LocalDensity.current) { 70.dp.toPx() }
    val imageCyCoordinate = with(LocalDensity.current) { 90.dp.toPx() }
    val textTopMargin = with(LocalDensity.current) { 200.dp.toPx() }
    val iconTopMargin = with(LocalDensity.current) { 460.dp.toPx() }
    val numberTextSize = with(LocalDensity.current) { 50.sp.toPx() }
    val scaleTextSize = with(LocalDensity.current) { 12.sp.toPx() }

    circleCoordinateX = with(LocalDensity.current) { 288.dp.toPx() }
    scaleVerticalMargin = with(LocalDensity.current) { 124.dp.toPx() }
    scaleBottomMargin = with(LocalDensity.current) { 62.dp.toPx() }
    scaleRightMargin = with(LocalDensity.current) { 10.dp.toPx() }
    radius = with(LocalDensity.current) { 30.dp.toPx() }
    border = with(LocalDensity.current) { 2.dp.toPx() }

    val circlePoint: MutableState<Offset> = remember {
        mutableStateOf(Offset(0f, 0f))
    }

    val choosePart: MutableState<Int> = remember {
        mutableStateOf(4)
    }

    val scalePaint = Paint().apply {
        color = Color.Gray
        strokeWidth = 3f
    }
    val cardShader = LinearGradientShader(
        from = Offset(20f, 0f),
        to = Offset(20f, height.value),
        colors = card.cardBorderColors,
    )

    val innerCardShader = LinearGradientShader(
        from = Offset(20f, border),
        to = Offset(circleCoordinateX, height.value),
        colors = card.cardColors,
    )

    val innerCircleShader = LinearGradientShader(
        from = Offset(circlePoint.value.x - radius + border, circlePoint.value.y - radius + border),
        to = Offset(circlePoint.value.x + radius - border, circlePoint.value.y + radius - border),
        colors = card.cardColors,
    )

    val circleShader = LinearGradientShader(
        from = Offset(circlePoint.value.x - radius, circlePoint.value.y - radius),
        to = Offset(circlePoint.value.x + radius, circlePoint.value.y + radius),
        colors = card.cardBorderColors,
    )

    val cardPaint = Paint().apply {
        style = PaintingStyle.Stroke
        strokeWidth = border
        pathEffect = PathEffect.cornerPathEffect(20f)
    }
    val innerCardPaint = Paint().apply {
        style = PaintingStyle.Fill
        pathEffect = PathEffect.cornerPathEffect(20f)
    }

    val circlePaint = Paint().apply {
        style = PaintingStyle.Stroke
        strokeWidth = border
    }
    val innerCirclePaint = Paint().apply {
        style = PaintingStyle.Fill
    }

    val maskPaint = Paint().asFrameworkPaint().apply {
        isAntiAlias = true
        style = android.graphics.Paint.Style.FILL
        color = android.graphics.Color.WHITE
    }

    val typeIconPaint = Paint().asFrameworkPaint().apply {
        isAntiAlias = true
        style = android.graphics.Paint.Style.FILL
    }

    val textPaint = TextPaint().apply {
        isAntiAlias = true
        textSize = numberTextSize
        color = android.graphics.Color.WHITE
    }

    val textScalePaint = TextPaint().apply {
        isAntiAlias = true
        textSize = scaleTextSize
        textAlign = android.graphics.Paint.Align.RIGHT
        color = android.graphics.Color.GRAY
    }

    val sourceBitmap = LocalContext.current.getDrawable(R.drawable.ic_iron_man)
        ?.toBitmap(innerMaskImageWidth, innerMaskImageHeight, Bitmap.Config.ARGB_8888)
    val maskBitmap = Bitmap.createBitmap(imageSize, imageSize, Bitmap.Config.ARGB_8888)
    val resultBitmap = maskBitmap.copy(Bitmap.Config.ARGB_8888, true)
    val maskCanvas = android.graphics.Canvas(maskBitmap)
    maskCanvas.drawCircle(imageCxCoordinate, imageCyCoordinate, imageRadius, maskPaint)
    maskPaint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
    val resultCanvas = android.graphics.Canvas(resultBitmap)
    resultCanvas.drawBitmap(maskBitmap, 0f, 0f, null)
    sourceBitmap?.let { resultCanvas.drawBitmap(it, 90f, 130f, null) }

    val iconSourceBitmap = LocalContext.current.getDrawable(R.drawable.ic_master)
        ?.toBitmap(cardIconWidth, cardIconHeight, Bitmap.Config.ARGB_8888)
    typeIconPaint.colorFilter =
        PorterDuffColorFilter(card.iconColor.toArgb(), PorterDuff.Mode.SRC_IN)

    val circleIconBitmap = LocalContext.current.getDrawable(R.drawable.ic_circle_arrow)
        ?.toBitmap(circleIconWidth, circleIconHeight, Bitmap.Config.ARGB_8888)

    Canvas(modifier = Modifier
        .fillMaxWidth()
        .height(524.dp)
        .onSizeChanged {
            height.value = it.height.toFloat()
            width = it.width.toFloat()
            scaleHeight = height.value - scaleVerticalMargin
            axisYStep = scaleHeight / (countParts - 1)
            circlePoint.value = calculateCircleCoordinates(choosePart.value)
            cardPoints = calculateCardListPoints(circlePoint)
            additionalPoints = additionalCirclePoints()
            scaleListPoints = calculateScalePoints()
            buildCardPath(
                path = cardPath,
            )
        }
        .pointerInteropFilter { event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    downY.value = event.y
                }
                MotionEvent.ACTION_MOVE -> {
                    val x = event.x
                    val y = event.y
                    val deltaY = downY.value - event.y
                    if (x in (circlePoint.value.x - radius..circlePoint.value.x + radius)) {
                        if (deltaY >= 0 && y < (circlePoint.value.y - radius) && choosePart.value >= 1) {
                            downY.value = circlePoint.value.y
                            val pos = choosePart.value - 1
                            updateCoordinates(circlePoint, choosePart, pos)
                        } else if (deltaY < 0 && y > (circlePoint.value.y + radius) && choosePart.value <= 8) {
                            downY.value = circlePoint.value.y
                            val pos = choosePart.value + 1
                            updateCoordinates(circlePoint, choosePart, pos)
                        }
                    }
                }
                MotionEvent.ACTION_UP -> {
                }
            }
            true
        }
    ) {

        cardPaint.shader = cardShader
        innerCardPaint.shader = innerCardShader
        circlePaint.shader = circleShader
        innerCirclePaint.shader = innerCircleShader

        drawIntoCanvas { canvas ->
            drawCircle(
                canvas = canvas,
                outerPaint = circlePaint,
                innerPaint = innerCirclePaint,
                center = circlePoint.value,
                bitmap = circleIconBitmap,
                bitmapCenter = Offset(circleIconWidth.toFloat(), circleIconHeight.toFloat())
            )
            drawScale(
                canvas = canvas,
                scalePoints = scaleListPoints,
                paint = scalePaint,
                textPaint = textScalePaint,
            )
            drawCard(
                canvas = canvas,
                innerPaint = innerCardPaint,
                outerPaint = cardPaint,
                path = cardPath
            )
            drawImage(
                canvas = canvas.nativeCanvas,
                bitmap = resultBitmap
            )
            drawBudget(
                canvas = canvas.nativeCanvas,
                number = "$${currentSum(position)}",
                coordinates = Offset(leftMargin, textTopMargin),
                paint = textPaint
            )
            drawCardType(
                canvas = canvas.nativeCanvas,
                bitmap = iconSourceBitmap,
                coordinates = Offset(leftMargin, iconTopMargin),
                paint = typeIconPaint
            )
        }
    }
}

private fun updateCoordinates(
    circlePoint: MutableState<Offset>,
    choosePart: MutableState<Int>,
    pos: Int
) {
    position = pos
    choosePart.value = pos
    circlePoint.value = calculateCircleCoordinates(pos)
    cardPoints = calculateCardListPoints(circlePoint)
    additionalPoints = additionalCirclePoints()
    scaleListPoints = calculateScalePoints()
    buildCardPath(cardPath)
}

private fun drawImage(
    canvas: android.graphics.Canvas,
    bitmap: Bitmap
) {
    canvas.drawBitmap(bitmap, 0f, 0f, null)
}

private fun drawCardType(
    canvas: android.graphics.Canvas,
    bitmap: Bitmap?,
    coordinates: Offset,
    paint: android.graphics.Paint
) {
    bitmap?.let { canvas.drawBitmap(it, coordinates.x, coordinates.y, paint) }
}

private fun drawBudget(
    canvas: android.graphics.Canvas,
    number: String,
    coordinates: Offset,
    paint: TextPaint
) {
    canvas.drawText(number, coordinates.x, coordinates.y, paint)
}

private fun drawCircle(
    canvas: Canvas,
    innerPaint: Paint,
    outerPaint: Paint,
    center: Offset,
    bitmap: Bitmap?,
    bitmapCenter: Offset
) {
    canvas.drawCircle(
        center = center,
        radius = radius - border,
        paint = innerPaint
    )
    canvas.drawCircle(
        center = center,
        radius = radius,
        paint = outerPaint
    )
    bitmap?.let {
        canvas.nativeCanvas.drawBitmap(
            it,
            center.x - bitmapCenter.x / 2,
            center.y - bitmapCenter.y / 2,
            null
        )
    }
}

private fun drawScale(canvas: Canvas, scalePoints: List<PointF>, paint: Paint, textPaint: TextPaint) {
    val lastIndex = scalePoints.lastIndex
    scalePoints.forEachIndexed { index, point ->
        when (index) {
            0 -> canvas.nativeCanvas.drawText("$"+ minSum, point.x, point.y, textPaint)
            lastIndex -> canvas.nativeCanvas.drawText("$"+ max.toString(), point.x, point.y, textPaint)
            else -> canvas.drawLine(Offset(point.x, point.y), Offset(point.x - 20f, point.y), paint)
        }
    }
}

private fun drawCard(canvas: Canvas, innerPaint: Paint, outerPaint: Paint, path: Path) {
    canvas.drawPath(path, innerPaint)
    canvas.drawPath(path, outerPaint)
}

private fun buildCardPath(path: Path) {
    path.reset()
    cardPoints.forEachIndexed { index, point ->
        when (index) {
            0 -> path.moveTo(point.x, point.y)
            3 -> {
                path.cubicTo(
                    additionalPoints[0].x, additionalPoints[0].y,
                    additionalPoints[1].x, additionalPoints[1].y,
                    point.x, point.y,
                )
            }
            4 -> {
                path.cubicTo(
                    additionalPoints[2].x, additionalPoints[2].y,
                    additionalPoints[3].x, additionalPoints[3].y,
                    point.x, point.y + radius / 3
                )
            }
            else -> path.lineTo(point.x, point.y)
        }
    }
    path.close()
}

private fun calculateScalePoints(): List<PointF> {
    val points = mutableListOf<PointF>()
    val scaleHeight = height.value - scaleBottomMargin
    val coordinateX = width - scaleRightMargin
    for (i in 0 until countParts) {
        val step = scaleHeight - axisYStep * i
        points.add(PointF(coordinateX, step))
    }
    return points
}

private fun additionalCirclePoints(): List<PointF> {
    val topCirclePoint = cardPoints[2]
    val middleCirclePoint = cardPoints[3]
    val bottomCirclePoint = cardPoints[4]

    val additionFirstTopCirclePoint = PointF(topCirclePoint.x, topCirclePoint.y + radius / 3)
    val additionSecondTopCirclePoint =
        PointF(middleCirclePoint.x, middleCirclePoint.y - 4 * radius / 3)
    val additionFirstBottomCirclePoint =
        PointF(middleCirclePoint.x, middleCirclePoint.y + 4 * radius / 3)
    val additionSecondBottomCirclePoint =
        PointF(bottomCirclePoint.x, bottomCirclePoint.y - radius / 3)

    return listOf(
        additionFirstTopCirclePoint,
        additionSecondTopCirclePoint,
        additionFirstBottomCirclePoint,
        additionSecondBottomCirclePoint
    )
}

private fun calculateCardListPoints(
    circlePoint: MutableState<Offset>
): List<Offset> {
    val topCirclePoint = Offset(circlePoint.value.x, circlePoint.value.y - axisYStep)
    val bottomCirclePoint = Offset(circlePoint.value.x, circlePoint.value.y + axisYStep)
    val middleCirclePoint = Offset(circlePoint.value.x - 1.3f * radius, circlePoint.value.y)

    return listOf(
        Offset(-20f, border),
        Offset(circlePoint.value.x, border),
        topCirclePoint,
        middleCirclePoint,
        bottomCirclePoint,
        Offset(circlePoint.value.x, height.value - border),
        Offset(-20f, height.value - border),
    )
}


private fun calculateCircleCoordinates(
    choosePart: Int,
): Offset {
    val y = choosePart * axisYStep + scaleBottomMargin
    return Offset(circleCoordinateX, y)
}
