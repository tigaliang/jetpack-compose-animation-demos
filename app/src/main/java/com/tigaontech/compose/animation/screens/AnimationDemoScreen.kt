package com.tigaontech.compose.animation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tigaontech.compose.animation.ui.components.ScreenHeader

@Composable
fun AnimationDemoScreen(demo: AnimationDemo) {
    Column(modifier = Modifier.fillMaxSize()) {
        ScreenHeader()

        when (demo) {
            AnimationDemo.DemoA -> {
                Text(text = "Demonstrating animation A")
            }
            AnimationDemo.DemoB -> {
                Button(onClick = {}) {
                    Text(text = "Demonstrating animation B")
                }
            }
        }
    }
}
