package com.tigaontech.compose.animation.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview
fun ScreenHeader() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        Text(text = "Compose Animation Demos", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Author: @tigaontech.com",
            fontSize = 12.sp
        )
    }
}
