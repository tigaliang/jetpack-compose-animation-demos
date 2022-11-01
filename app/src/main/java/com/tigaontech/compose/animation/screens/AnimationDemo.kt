package com.tigaontech.compose.animation.screens

enum class AnimationDemo(
    val displayName: String
) {
    AnimateStates("通过改变某个属性实现动画"),
    AnimatedVisibility("显示-隐藏的动画"),
    AnimateContentSize("组件的内容大小发生变化时的动画"),
    LazyListItemChanges("列表项发生变化时的动画"),
    AnimatedContent("不同组件切换的动画")
    ;

    companion object {
        fun of(displayName: String) = values().firstOrNull { it.displayName == displayName }
    }
}
