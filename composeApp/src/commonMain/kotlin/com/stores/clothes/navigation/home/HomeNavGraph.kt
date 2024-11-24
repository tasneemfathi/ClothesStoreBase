package com.stores.clothes.navigation.home

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.stores.clothes.navigation.Destinations
import com.stores.clothes.ui.scence.home.HomeScreen



fun NavGraphBuilder.homeNavigationHost(navController: NavHostController) {
    composable(route = Destinations.HomeScreen.toString()){
        HomeScreen()
    }
}

