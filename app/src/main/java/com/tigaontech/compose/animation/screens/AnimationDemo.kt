package com.tigaontech.compose.animation.screens

enum class AnimationDemo(
    val displayName: String
) {
    AnimateStates("animate*AsState"),
    AnimatedVisibility("AnimatedVisibility"),
    AnimateContentSize("animateContentSize"),
    LazyListItemChanges("animateItemPlacement"),
    AnimatedContent("AnimatedContent")
    ;

    companion object {
        fun of(displayName: String) = values().firstOrNull { it.displayName == displayName }
    }
}
