package com.tigaontech.compose.animation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tigaontech.compose.animation.screens.AnimationDemo
import com.tigaontech.compose.animation.screens.AnimationDemoScreen
import com.tigaontech.compose.animation.screens.AnimationListScreen
import com.tigaontech.compose.animation.ui.theme.ComposeAnimationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAnimationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ANIMATION_LIST_SCREEN) {
        composable(ANIMATION_LIST_SCREEN) {
            AnimationListScreen(navController = navController)
        }

        composable(route = "$ANIMATION_DEMO_SCREEN/{demo_name}",
            arguments = listOf(
                navArgument("demo_name") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            backStackEntry.arguments?.getString("demo_name")?.let {
                AnimationDemo.of(it)?.let { demo ->
                    AnimationDemoScreen(demo)
                }
            }
        }
    }
}

const val ANIMATION_LIST_SCREEN = "animation_list_screen"
const val ANIMATION_DEMO_SCREEN = "animation_demo_screen"
