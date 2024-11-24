package com.stores.clothes.ui.scence.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.stores.clothes.navigation.start.StartRouteEntryPoints
import com.stores.clothes.navigation.start.determineStartEntryPoint
import com.stores.clothes.ui.scence.splash.viewModel.SplashViewModel
import kotlinx.coroutines.delay
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun SplashScreen(onFinish:(StartRouteEntryPoints) -> Unit){
    val viewModel = koinViewModel<SplashViewModel> ()
    val isFirstLaunch  by viewModel.isFirstLaunch.collectAsState(initial = false)
    val isUserNotLoggedIn  by viewModel.isUserNotLoggedIn.collectAsState(initial = false)

    val scale = remember {
        Animatable(0.0f)
    }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(800, easing = LinearEasing)
        )
        delay(2000)
        onFinish(determineStartEntryPoint(isUserNotLoggedIn, isFirstLaunch))
    }

    SplashScreenContent(scale)
}
