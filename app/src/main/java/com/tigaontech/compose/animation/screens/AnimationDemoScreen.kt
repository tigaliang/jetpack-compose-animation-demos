package com.tigaontech.compose.animation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tigaontech.compose.animation.ui.components.ScreenHeader
import com.tigaontech.compose.animation.ui.demos.AnimateContentSizeDemo
import com.tigaontech.compose.animation.ui.demos.AnimateStatesDemo
import com.tigaontech.compose.animation.ui.demos.AnimatedVisibilityDemo
import com.tigaontech.compose.animation.ui.demos.LazyItemChangesDemo

@Composable
fun AnimationDemoScreen(demo: AnimationDemo) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ScreenHeader()

        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            when (demo) {
                AnimationDemo.AnimateStates -> AnimateStatesDemo()
                AnimationDemo.AnimatedVisibility -> AnimatedVisibilityDemo()
                AnimationDemo.AnimateContentSize -> AnimateContentSizeDemo()
                AnimationDemo.LazyListItemChanges -> LazyItemChangesDemo()
            }
        }
    }
}
