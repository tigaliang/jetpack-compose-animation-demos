package com.tigaontech.compose.animation.ui.demos

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tigaontech.compose.animation.ui.components.DemoBlock
import kotlinx.coroutines.delay

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedContentDemo() {
    DemoBlock(title = "文字轮播动画") {
        val items = listOf("小虾米～ 小虾米～", "聪明又伶俐", "小虾米～ 小虾米～ ", "可爱又帅气")
        var index by remember { mutableStateOf(0) }

        LaunchedEffect("carousel timer") {
            while (true) {
                delay(2000L)
                index = (index + 1) % items.size
            }
        }

        Box(
            modifier = Modifier
                .background(
                    color = Color(0x4000ff00),
                    shape = RoundedCornerShape(4.dp)
                )
                .padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            AnimatedContent(
                targetState = index,
                transitionSpec = {
                    slideInVertically { fullHeight -> fullHeight } + fadeIn() with
                            slideOutVertically() { fullHeight -> -fullHeight } + fadeOut()
                }
            ) { targetIndex ->
                // 注意这里要用 targetIndex 而不要直接用 index
                Text(text = items[targetIndex], style = TextStyle(fontSize = 32.sp))
            }
        }
    }
}
