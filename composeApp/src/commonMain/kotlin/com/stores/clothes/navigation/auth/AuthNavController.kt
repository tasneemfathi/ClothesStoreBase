package com.stores.clothes.navigation.auth

import androidx.navigation.NavController
import com.stores.clothes.navigation.Destinations

fun NavController.navigateToLoginScreen(){
    navigate(Destinations.LoginScreen.toString())
}

fun NavController.navigateToVerifyScreen(mobile:String){
    navigate("${Destinations.VerifyScreen}/${mobile}")
}