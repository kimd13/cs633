package edu.bu.cs633.ui.launch

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import edu.bu.authentication.ui.GivenIsSignedIn
import edu.bu.cs633.R
import kotlinx.coroutines.delay

@Composable
fun LaunchScreen(
    navigateToOnboarding: () -> Unit,
    navigateToHome: () -> Unit
) {
    val scale = remember { Animatable(0f) }

    GivenIsSignedIn(
        content = { isSignedIn ->
            LaunchedEffect(key1 = true) {
                scale.animateTo(
                    targetValue = 0.7f,
                    animationSpec = tween(
                        durationMillis = 800,
                        easing = {
                            OvershootInterpolator(4f).getInterpolation(it)
                        })
                )
                delay(3000L)
                if (isSignedIn) {
                    navigateToHome()
                } else {
                    navigateToOnboarding()
                }
            }

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "launcher logo",
                    modifier = Modifier.scale(scale.value)
                )
            }
        }
    )
}