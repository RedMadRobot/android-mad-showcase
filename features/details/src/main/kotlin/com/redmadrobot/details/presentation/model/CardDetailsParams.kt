package com.redmadrobot.details.presentation.model

import android.graphics.PointF
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path

const val countParts = 10

val choosePart: MutableState<Int> = mutableStateOf(4)
var circlePoint: MutableState<Offset> = mutableStateOf(Offset(0f, 0f))
var cardPoints = emptyList<Offset>()
var additionalPoints = emptyList<PointF>()
var scaleListPoints = emptyList<PointF>()
var downY = mutableStateOf(0f)
val cardPath = Path()
var axisYStep = 0f
var circleCoordinateX = 0f
var scaleVerticalMargin = 0f
var scaleBottomMargin = 0f
var scaleRightMargin = 0f
var radius = 0f
var height = mutableStateOf(0f)
var width = 0f
var scaleHeight = 0f
var border = 0f