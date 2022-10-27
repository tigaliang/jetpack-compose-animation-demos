@file:OptIn(ExperimentalAnimationApi::class)

package com.tigaontech.compose.animation.ui.demos

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandIn
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOut
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.tigaontech.compose.animation.R
import com.tigaontech.compose.animation.ui.components.DemoBlock
import com.tigaontech.compose.animation.ui.components.SimpleButton
import com.tigaontech.compose.animation.utils.toggle

@Composable
fun AnimatedVisibilityDemo() {
    DemoBlock(title = "默认方式") {
        var visible by remember { mutableStateOf(true) }

        SimpleButton(text = if (visible) "隐藏" else "显示") {
            visible = visible.toggle()
        }

        AnimatedVisibility(visible = visible) {
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = "launcher icon",
                modifier = Modifier
                    .size(60.dp)
            )
        }
    }

    DemoBlock(title = "fadeIn/fadeOut") {
        var visible by remember { mutableStateOf(true) }

        SimpleButton(text = if (visible) "隐藏" else "显示") {
            visible = visible.toggle()
        }

        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = "launcher icon",
                modifier = Modifier
                    .size(60.dp)
            )
        }
    }

    DemoBlock(title = "slideIn/slideOut") {
        var visible by remember { mutableStateOf(true) }

        SimpleButton(text = if (visible) "隐藏" else "显示") {
            visible = visible.toggle()
        }

        AnimatedVisibility(
            visible = visible,
            enter = slideIn(initialOffset = { size -> IntOffset(0, size.height) }),
            exit = slideOut(targetOffset = { size -> IntOffset(0, size.height) })
        ) {
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = "launcher icon",
                modifier = Modifier
                    .size(60.dp)
            )
        }
    }

    DemoBlock(title = "slideInHorizontally/slideOutHorizontally") {
        var visible by remember { mutableStateOf(true) }

        SimpleButton(text = if (visible) "隐藏" else "显示") {
            visible = visible.toggle()
        }

        AnimatedVisibility(
            visible = visible,
            enter = slideInHorizontally(),
            exit = slideOutHorizontally()
        ) {
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = "launcher icon",
                modifier = Modifier
                    .size(60.dp)
            )
        }
    }

    DemoBlock(title = "slideInVertically/slideOutVertically") {
        var visible by remember { mutableStateOf(true) }

        SimpleButton(text = if (visible) "隐藏" else "显示") {
            visible = visible.toggle()
        }

        AnimatedVisibility(
            visible = visible,
            enter = slideInVertically(),
            exit = slideOutVertically()
        ) {
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = "launcher icon",
                modifier = Modifier
                    .size(60.dp)
            )
        }
    }

    DemoBlock(title = "scaleIn/scaleOut") {
        var visible by remember { mutableStateOf(true) }

        SimpleButton(text = if (visible) "隐藏" else "显示") {
            visible = visible.toggle()
        }

        AnimatedVisibility(
            visible = visible,
            enter = scaleIn(),
            exit = scaleOut()
        ) {
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = "launcher icon",
                modifier = Modifier
                    .size(60.dp)
            )
        }
    }

    DemoBlock(title = "scaleIn/scaleOut 指定初始和结束的大小以及缩放的参考点为右上角") {
        var visible by remember { mutableStateOf(true) }

        SimpleButton(text = if (visible) "隐藏" else "显示") {
            visible = visible.toggle()
        }

        AnimatedVisibility(
            visible = visible,
            enter = scaleIn(initialScale = 0.2f, transformOrigin = TransformOrigin(1f, 0f)),
            exit = scaleOut(targetScale = 0.2f, transformOrigin = TransformOrigin(1f, 0f))
        ) {
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = "launcher icon",
                modifier = Modifier
                    .size(60.dp)
            )
        }
    }

    DemoBlock(title = "expandIn/shrinkOut") {
        var visible by remember { mutableStateOf(true) }

        SimpleButton(text = if (visible) "隐藏" else "显示") {
            visible = visible.toggle()
        }

        AnimatedVisibility(
            visible = visible,
            enter = expandIn(),
            exit = shrinkOut()
        ) {
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = "launcher icon",
                modifier = Modifier
                    .size(60.dp)
            )
        }
    }

    DemoBlock(title = "expandIn/shrinkOut 指定扩展和收缩的参考位置为左上角") {
        var visible by remember { mutableStateOf(true) }

        SimpleButton(text = if (visible) "隐藏" else "显示") {
            visible = visible.toggle()
        }

        AnimatedVisibility(
            visible = visible,
            enter = expandIn(expandFrom = Alignment.TopStart),
            exit = shrinkOut(shrinkTowards = Alignment.TopStart)
        ) {
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = "launcher icon",
                modifier = Modifier
                    .size(60.dp)
            )
        }
    }

    DemoBlock(title = "expandHorizontally/shrinkHorizontally") {
        var visible by remember { mutableStateOf(true) }

        SimpleButton(text = if (visible) "隐藏" else "显示") {
            visible = visible.toggle()
        }

        AnimatedVisibility(
            visible = visible,
            enter = expandHorizontally(),
            exit = shrinkHorizontally()
        ) {
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = "launcher icon",
                modifier = Modifier
                    .size(60.dp)
            )
        }
    }

    DemoBlock(title = "expandVertically/shrinkVertically") {
        var visible by remember { mutableStateOf(true) }

        SimpleButton(text = if (visible) "隐藏" else "显示") {
            visible = visible.toggle()
        }

        AnimatedVisibility(
            visible = visible,
            enter = expandVertically(),
            exit = shrinkVertically()
        ) {
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = "launcher icon",
                modifier = Modifier
                    .size(60.dp)
            )
        }
    }

    DemoBlock(title = "animateFloatAsState 改变透明度实现隐藏和显示") {
        var visible by remember { mutableStateOf(true) }
        val alpha by animateFloatAsState(targetValue = if (visible) 1f else 0f)

        SimpleButton(text = if (visible) "隐藏" else "显示") {
            visible = visible.toggle()
        }

        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = "launcher icon",
            alpha = alpha,
            modifier = Modifier
                .size(60.dp)
        )
    }
}
