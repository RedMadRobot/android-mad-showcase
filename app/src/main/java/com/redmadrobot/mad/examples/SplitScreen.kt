package com.redmadrobot.mad.examples

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun SplitScreen() {
    Column {
        Box(modifier = Modifier.weight(1f)) {
            SampleScreenRouter("A")
        }
        Divider(color = Color.Black)
        Box(modifier = Modifier.weight(1f)) {
            SampleScreenRouter("B")
        }
    }

}