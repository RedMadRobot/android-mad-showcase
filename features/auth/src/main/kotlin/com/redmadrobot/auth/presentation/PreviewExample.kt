package com.redmadrobot.auth.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.redmadrobot.auth.R

@Preview
@Composable
fun AuthScreenLoading() {
    Text(
        text = stringResource(id = R.string.login_title),
        color = Color.White,
        modifier = Modifier.padding(bottom = 12.dp)
    )
}