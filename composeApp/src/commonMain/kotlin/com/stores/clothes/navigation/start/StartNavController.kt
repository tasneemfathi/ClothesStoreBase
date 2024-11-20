package com.stores.clothes.navigation.start

import androidx.navigation.NavController
import com.stores.clothes.navigation.Destinations

fun NavController.navigateToIntroScreen(){
    navigate(Destinations.IntroScreen.toString())
}
