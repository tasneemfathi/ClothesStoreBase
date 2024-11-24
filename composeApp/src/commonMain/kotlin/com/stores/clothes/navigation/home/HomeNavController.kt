package com.stores.clothes.navigation.home

import androidx.navigation.NavController
import com.stores.clothes.navigation.Destinations

fun NavController.navigateToHomeScreen(){
    navigate(Destinations.HomeScreen.toString())
}

