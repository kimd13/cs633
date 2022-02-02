package edu.cs633.onboarding.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import edu.bu.onboarding.R
import edu.cs633.onboarding.ui.model.Page
import kotlinx.coroutines.launch

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun OnboardingScreen(
    onFinish: () -> Unit
) {
    val pages = listOf(
        Page(
            image = R.drawable.onboarding_1,
            backgroundColor = R.color.red
        ),
        Page(
            image = R.drawable.onboarding_2,
            backgroundColor = R.color.green
        ),
        Page(
            image = R.drawable.onboarding_3,
            backgroundColor = R.color.orange
        )
    )

    val padding = 16.dp
    val scope = rememberCoroutineScope()
    val pagesCount = pages.size
    val pagerState = rememberPagerState()
    val pagerBackgroundColor = pages[pagerState.currentPage].backgroundColor

    Column(
        modifier = Modifier
            .background(colorResource(id = pagerBackgroundColor))
            .padding(padding)
    ) {
        PagerButton(
            text = stringResource(id = R.string.skip),
            onClick = {
                scope.launch {
                    pagerState.scrollToPage(pagesCount - 1)
                }
            },
            isVisible = (pagerState.currentPage != pagesCount - 1),
            modifier = Modifier
                .align(Alignment.End)
        )

        HorizontalPager(
            count = pagesCount,
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { index ->

            PageScreen(page = pages[index])
        }

        PagerButton(
            text = stringResource(id = R.string.finish_onboarding),
            onClick = onFinish,
            isVisible = (pagerState.currentPage == pagesCount - 1),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.padding(padding))

        HorizontalPagerIndicator(
            pagerState = pagerState,
            activeColor = MaterialTheme.colors.onPrimary,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
    }
}

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
private fun PagerButton(
    text: String,
    onClick: () -> Unit,
    isVisible: Boolean,
    modifier: Modifier
) {
    AnimatedVisibility(
        visible = isVisible,
        modifier = modifier
    ) {
        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.secondary
            ),
            onClick = onClick
        ) {
            Text(
                text = text,
                color = MaterialTheme.colors.onSecondary
            )
        }
    }
}