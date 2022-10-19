package com.tigaontech.compose.animation.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DemoBlock(
    title: String,
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(text = ">> $title")

        Spacer(modifier = Modifier.height(16.dp))

        content()

        Spacer(modifier = Modifier.height(16.dp))

        Divider()
    }
}
