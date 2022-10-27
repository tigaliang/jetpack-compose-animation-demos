package com.tigaontech.compose.animation.ui.demos

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tigaontech.compose.animation.R
import com.tigaontech.compose.animation.ui.components.DemoBlock
import com.tigaontech.compose.animation.ui.components.SimpleButton
import com.tigaontech.compose.animation.utils.toggle

@Composable
fun AnimateContentSizeDemo() {
    DemoBlock(title = "animateContentSize 改变大小") {
        var expanded by remember { mutableStateOf(true) }

        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = 10.dp
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .animateContentSize(),
            ) {
                SimpleButton(text = if (expanded) "收起" else "展开") {
                    expanded = expanded.toggle()
                }

                if (expanded) {
                    Image(
                        painter = painterResource(id = R.drawable.android_logo),
                        contentDescription = "launcher icon",
                        modifier = Modifier.size(60.dp)
                    )
                }
            }
        }
    }
}
