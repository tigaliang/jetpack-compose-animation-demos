package com.tigaontech.compose.animation.ui.demos

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tigaontech.compose.animation.R
import com.tigaontech.compose.animation.ui.components.DemoBlock
import com.tigaontech.compose.animation.ui.components.SimpleButton

@Composable
fun AnimateStatesDemo() {
    DemoBlock(title = "使用 animateColorAsState 改变颜色") {
        var animationState by remember { mutableStateOf(true) }
        val color by animateColorAsState(targetValue = if (animationState) Color.Green else Color.Blue)

        Box(
            Modifier
                .size(60.dp)
                .background(color)
        )

        Spacer(modifier = Modifier.height(16.dp))

        SimpleButton(text = "改变方块颜色") {
            animationState = animationState.toggle()
        }
    }

    DemoBlock(title = "使用 animateDpAsState 改变大小") {
        var animationState by remember { mutableStateOf(true) }
        val size by animateDpAsState(targetValue = if (animationState) 60.dp else 20.dp)

        Box(
            Modifier
                .size(size)
                .background(Color.Green)
        )

        Spacer(modifier = Modifier.height(16.dp))

        SimpleButton(text = "改变方块大小") {
            animationState = animationState.toggle()
        }
    }

    DemoBlock(title = "使用 animateOffsetAsState 改变位置") {
        var animationState by remember { mutableStateOf(true) }
        val offset by animateOffsetAsState(
            targetValue = if (animationState) {
                Offset.Zero
            } else {
                Offset(77f, 37f)
            }
        )

        Box(
            Modifier
                .width(200.dp)
                .height(60.dp)
                .background(Color.Green)
        ) {
            Text(
                "TigaOnTech.com",
                modifier = Modifier.offset(offset.x.dp, offset.y.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        SimpleButton(text = "改变文字位置") {
            animationState = animationState.toggle()
        }
    }

    DemoBlock(title = "使用 animateFloatAsState 改变透明度") {
        var animationState by remember { mutableStateOf(true) }
        val alpha by animateFloatAsState(targetValue = if (animationState) 1f else 0.3f)

        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = "launcher icon",
            modifier = Modifier
                .size(60.dp)
                .alpha(alpha)
        )

        Spacer(modifier = Modifier.height(16.dp))

        SimpleButton(text = "改变图片透明度") {
            animationState = animationState.toggle()
        }
    }

    DemoBlock(title = "使用 animateSizeAsState 改变大小") {
        var animationState by remember { mutableStateOf(true) }
        val size by animateSizeAsState(
            targetValue = if (animationState) {
                Size(10f, 10f)
            } else {
                Size(50f, 50f)
            }
        )

        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = "launcher icon",
            modifier = Modifier
                .width(size.width.dp)
                .height(size.height.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        SimpleButton(text = "改变图片大小") {
            animationState = animationState.toggle()
        }
    }

    DemoBlock(title = "使用 animateRectAsState 改变大小和位置") {
        var animationState by remember { mutableStateOf(true) }
        val rect by animateRectAsState(
            targetValue = if (animationState) {
                Rect(Offset.Zero, Size(10f, 10f))
            } else {
                Rect(Offset(100f, 30f), Size(50f, 50f))
            }
        )

        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = "launcher icon",
            modifier = Modifier
                .width(rect.size.width.dp)
                .height(rect.size.height.dp)
                .offset(rect.left.dp, rect.top.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        SimpleButton(text = "改变图片大小和位置") {
            animationState = animationState.toggle()
        }
    }

    DemoBlock(title = "使用 animateIntAsState 改变文本大小") {
        var animationState by remember { mutableStateOf(true) }
        val fontSize by animateIntAsState(
            targetValue = if (animationState) {
                12
            } else {
                24
            }
        )

        Text(text = "TigaOnTech.com", fontSize = fontSize.sp)

        Spacer(modifier = Modifier.height(16.dp))

        SimpleButton(text = "改变文本大小") {
            animationState = animationState.toggle()
        }
    }

    DemoBlock(title = "使用 animationSpec 和 finishedListener 调整动画参数") {
        var hintText by remember { mutableStateOf("绿色") }
        var animationState by remember { mutableStateOf(true) }
        val color by animateColorAsState(
            targetValue = if (animationState) Color.Green else Color.Blue,
            animationSpec = tween(durationMillis = 600, easing = LinearEasing),
            finishedListener = {
                hintText = if (animationState) "绿色" else "蓝色"
            }
        )

        Box(
            Modifier
                .size(60.dp)
                .background(color)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "当前方块颜色是：$hintText")

        Spacer(modifier = Modifier.height(16.dp))

        SimpleButton(text = "改变方块颜色") {
            animationState = animationState.toggle()
        }
    }
}

fun Boolean.toggle() = !this
