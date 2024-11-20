package com.stores.clothes.navigation.start


import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.stores.clothes.navigation.Destinations
import com.stores.clothes.navigation.auth.navigateToLoginScreen
import com.stores.clothes.ui.scence.intro.view.IntroScreen
import com.stores.clothes.ui.scence.splash.SplashScreen

fun NavGraphBuilder.startNavigationHost(navController: NavHostController) {
    composable(route = Destinations.SplashScreen.toString()){
        SplashScreen(onFinish = {navController.navigateToIntroScreen()})
    }
    composable(route = Destinations.IntroScreen.toString()){
        IntroScreen(onFinish = navController::navigateToLoginScreen)
    }


}

