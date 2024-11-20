package com.stores.clothes.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.stores.clothes.ui.core.AlerterComponents


@Composable
fun NavigationHost(){
    val navController: NavHostController = rememberNavController()
    val startDestination: Destinations = Destinations.SplashScreen
    Box(modifier = Modifier.fillMaxSize()){
        Scaffold(
            containerColor = Color.White) {
            Box(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
                NavHostGraph(navController = navController, startDestination = startDestination)
                AlerterComponents()
            }
        }
    }

}

