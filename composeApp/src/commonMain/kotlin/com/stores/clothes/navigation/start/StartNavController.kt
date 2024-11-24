package com.stores.clothes.navigation.start

import androidx.navigation.NavController
import com.stores.clothes.navigation.Destinations

fun NavController.startApp(start:StartRouteEntryPoints){
    when(start){
        StartRouteEntryPoints.Intro -> navigate(Destinations.IntroScreen.toString())
        StartRouteEntryPoints.Login -> navigate(Destinations.LoginScreen.toString())
        StartRouteEntryPoints.Home -> navigate(Destinations.HomeScreen.toString())
    }
}
