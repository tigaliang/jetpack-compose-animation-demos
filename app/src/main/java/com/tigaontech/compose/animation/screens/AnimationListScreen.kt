package com.tigaontech.compose.animation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tigaontech.compose.animation.ANIMATION_DEMO_SCREEN
import com.tigaontech.compose.animation.ui.components.ScreenHeader

@Composable
fun AnimationListScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        ScreenHeader()

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(AnimationDemo.values()) { demo ->
                Text(
                    text = demo.displayName,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .clickable {
                            navController.navigate("$ANIMATION_DEMO_SCREEN/${demo.displayName}")
                        }
                        .padding(16.dp)
                )

                Divider()
            }
        }
    }
}
