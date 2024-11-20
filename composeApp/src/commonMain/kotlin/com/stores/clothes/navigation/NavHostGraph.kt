package com.stores.clothes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.stores.clothes.navigation.auth.authNavigationHost
import com.stores.clothes.navigation.start.startNavigationHost


@Composable
fun NavHostGraph(navController: NavHostController,
                 startDestination: Destinations){
        NavHost(navController = navController, startDestination = startDestination.toString()){
             startNavigationHost(navController = navController)
             authNavigationHost(navController = navController)
        }
}
