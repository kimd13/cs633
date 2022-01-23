package edu.bu.cs633.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import edu.bu.cs633.ui.home.HomeScreen
import edu.bu.cs633.ui.launch.LaunchScreen

object Destination {
    const val LAUNCH_ROUTE = "launch"
    const val HOME_ROUTE = "home"
}

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun NavigationGraph(
    navigationController: NavHostController = rememberNavController(),
    startDestination: String = Destination.LAUNCH_ROUTE
) {
    val actions = remember(navigationController) { Actions(navigationController) }

    NavHost(
        navController = navigationController,
        startDestination = startDestination
    ) {
        composable(Destination.LAUNCH_ROUTE) {
            LaunchScreen(
                navigateToHome = actions.navigateToHome
            )
        }

        composable(Destination.HOME_ROUTE) {
            HomeScreen()
        }
    }
}

class Actions(navigationController: NavHostController) {

    val navigateToHome: () -> Unit = {
        navigationController.navigate(Destination.HOME_ROUTE) {
            popUpTo(Destination.LAUNCH_ROUTE) {
                inclusive = true
            }
        }
    }
}