package com.redmadrobot.mad

import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.redmadrobot.mad.AppRoute.SimpleRoute
import com.redmadrobot.mad.AppRoute.MultipleStartRoute
import com.redmadrobot.mad.AppRoute.BottomTabsRoute
import com.redmadrobot.mad.AppRoute.SplitScreenRoute
import com.redmadrobot.mad.AppRoute.ComplexRoute
import com.redmadrobot.mad.AppRoute.TranslucentRoute
import com.redmadrobot.mad.AppRoute.ResultRoute

@Composable
fun HomeScreen(onShowSample: (AppRoute) -> Unit) {
    val data = listOf(
        SimpleRoute,
        MultipleStartRoute,
        BottomTabsRoute,
        SplitScreenRoute,
        ComplexRoute,
        TranslucentRoute,
        ResultRoute,
    )

    LazyColumnFor(data) {
        Card(modifier = Modifier.fillParentMaxWidth().padding(8.dp).clickable(onClick = { onShowSample(it) })) {
            Text(
                text = it.toString(),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.h5
            )
        }
    }
}