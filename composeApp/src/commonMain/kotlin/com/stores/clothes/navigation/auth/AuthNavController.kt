package com.stores.clothes.navigation.auth

import androidx.navigation.NavController
import com.stores.clothes.navigation.Destinations
import com.stores.clothes.utils.log

fun NavController.navigateToLoginScreen(){
    navigate(Destinations.LoginScreen.toString())
}

fun NavController.navigateToVerifyScreen(countryId:String,mobile:String){
    navigate("${Destinations.VerifyScreen}/$countryId/${mobile}")
}