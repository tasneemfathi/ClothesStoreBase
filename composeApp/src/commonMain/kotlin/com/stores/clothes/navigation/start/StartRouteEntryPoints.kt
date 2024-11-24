package com.stores.clothes.navigation.start

fun determineStartEntryPoint(isUserNotLoggedIn:Boolean, isFirstLaunch:Boolean):StartRouteEntryPoints{
    return when{
        isFirstLaunch -> StartRouteEntryPoints.Intro
        isUserNotLoggedIn -> StartRouteEntryPoints.Login
        else -> StartRouteEntryPoints.Home
    }
}
enum class StartRouteEntryPoints{
    Intro,
    Login,
    Home
}