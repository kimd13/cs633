package edu.bu.cs633.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun Project() {
    MaterialTheme {
        val navigationController = rememberNavController()

        NavigationGraph(
            navigationController = navigationController
        )
    }
}