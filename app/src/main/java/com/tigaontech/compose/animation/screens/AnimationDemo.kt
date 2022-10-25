package com.tigaontech.compose.animation.screens

enum class AnimationDemo(
    val displayName: String
) {
    AnimateStates("通过改变某个属性实现动画"),
    AnimatedVisibility("显示/隐藏的动画");

    companion object {
        fun of(displayName: String) = values().firstOrNull { it.displayName == displayName }
    }
}