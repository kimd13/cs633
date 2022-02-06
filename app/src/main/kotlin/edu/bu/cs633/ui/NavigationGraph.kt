package edu.bu.cs633.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import edu.bu.authentication.ui.AuthenticationScreen
import edu.bu.cs633.ui.home.HomeScreen
import edu.bu.cs633.ui.launch.LaunchScreen
import edu.cs633.onboarding.ui.OnboardingScreen

object Destination {
    const val LAUNCH_ROUTE = "launch"
    const val HOME_ROUTE = "home"
    const val ONBOARDING_ROUTE = "onboarding"
    const val AUTHENTICATION_ROUTE = "authentication"
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
                navigateToOnboarding = actions.navigateToOnboarding,
                navigateToHome = actions.navigateToHome
            )
        }

        composable(Destination.ONBOARDING_ROUTE) {
            OnboardingScreen(
                onFinish = actions.navigateToAuthentication
            )
        }

        composable(Destination.HOME_ROUTE) {
            HomeScreen(
                navigateToAuthentication = actions.navigateToAuthentication
            )
        }

        composable(Destination.AUTHENTICATION_ROUTE) {
            AuthenticationScreen(
                onFinish = actions.navigateToHome
            )
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

    val navigateToOnboarding: () -> Unit = {
        navigationController.navigate(Destination.ONBOARDING_ROUTE) {
            popUpTo(Destination.LAUNCH_ROUTE) {
                inclusive = true
            }
        }
    }

    val navigateToAuthentication: () -> Unit = {
        navigationController.navigate(Destination.AUTHENTICATION_ROUTE)
    }
}