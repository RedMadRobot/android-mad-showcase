package com.redmadrobot.mad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { NewsStory() }
    }

    @Composable
    fun NewsStory() {
        Text("A day in Shark Fin Cove")
        Text("Davenport, California")
        Text("December 2018")
    }

    @Preview
    @Composable
    fun DefaultPreview() {
        NewsStory()
    }

}