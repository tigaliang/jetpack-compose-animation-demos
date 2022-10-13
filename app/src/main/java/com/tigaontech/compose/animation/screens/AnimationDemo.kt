package com.tigaontech.compose.animation.screens

enum class AnimationDemo(
    val displayName: String
) {
    DemoA("demo a"),
    DemoB("demo b");

    companion object {
        fun of(displayName: String) = values().firstOrNull { it.displayName == displayName }
    }
}
