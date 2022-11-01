package com.tigaontech.compose.animation.ui.demos

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tigaontech.compose.animation.ui.components.DemoBlock
import com.tigaontech.compose.animation.ui.components.SimpleButton

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyListItemChangesDemo() {
    DemoBlock(title = "animateContentSize 改变大小") {
        var items by remember {
            mutableStateOf(
                listOf(
                    "Item A",
                    "Item B",
                    "Item C",
                    "Item D",
                    "Item E",
                    "Item F"
                )
            )
        }

        SimpleButton(text = "打乱顺序") {
            items = items.shuffled()
        }

        LazyHorizontalGrid(rows = GridCells.Fixed(2), modifier = Modifier.height(200.dp)) {
            items(items.size, key = { items[it] }) { index ->
                Card(
                    elevation = 10.dp,
                    modifier = Modifier
                        .padding(8.dp)
                        .animateItemPlacement()
                ) {
                    Text(
                        text = items[index],
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}
