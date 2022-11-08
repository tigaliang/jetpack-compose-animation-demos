package com.tigaontech.compose.animation.ui.demos

import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tigaontech.compose.animation.R
import com.tigaontech.compose.animation.ui.components.DemoBlock
import com.tigaontech.compose.animation.ui.components.SimpleButton
import com.tigaontech.compose.animation.utils.toggle

@Preview
@Composable
fun UpdateTransitionDemo() {
    DemoBlock(title = "旋转的同时更新大小") {
        var targetState by remember { mutableStateOf(true) }
        val transition = updateTransition(targetState = targetState, label = "transition demo")

        SimpleButton(text = if (targetState) "变大" else "变小") {
            targetState = targetState.toggle()
        }

        val size by transition.animateDp(
            transitionSpec = { tween(durationMillis = 600) },
            label = "size"
        ) { state ->
            if (state) 40.dp else 80.dp
        }

        val rotation by transition.animateFloat(
            transitionSpec = { tween(durationMillis = 600) },
            label = "rotation"
        ) { state ->
            if (state) 0f else 360f
        }

        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = "android",
            modifier = Modifier
                .padding(top = 60.dp)
                .align(Alignment.CenterHorizontally)
                .size(size)
                .graphicsLayer {
                    rotationZ = rotation
                }
        )
    }

    DemoBlock(title = "旋转的同时更新大小(无限循环)") {
        val transitionState = remember { MutableTransitionState(true) }
        transitionState.targetState = transitionState.currentState.toggle()

        val transition =
            updateTransition(transitionState = transitionState, label = "transition demo")

        val size by transition.animateDp(
            transitionSpec = { tween(durationMillis = 600) },
            label = "size"
        ) { state ->
            if (state) 40.dp else 80.dp
        }

        val rotation by transition.animateFloat(
            transitionSpec = { tween(durationMillis = 600) },
            label = "rotation"
        ) { state ->
            if (state) 0f else 360f
        }

        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = "android",
            modifier = Modifier
                .padding(top = 60.dp)
                .align(Alignment.CenterHorizontally)
                .size(size)
                .graphicsLayer {
                    rotationZ = rotation
                }
        )
    }
}
