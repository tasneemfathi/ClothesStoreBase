package com.stores.clothes.navigation.auth

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.stores.clothes.navigation.Destinations
import com.stores.clothes.ui.scence.auth.view.login.LoginScreen
import com.stores.clothes.ui.scence.auth.view.verify.VerifyScreen
import com.stores.clothes.ui.scence.auth.viewModel.AuthViewModel
import org.koin.compose.viewmodel.koinViewModel


@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.authNavigationHost(navController: NavHostController) {
    composable(route = Destinations.LoginScreen.toString()){
        val viewModel: AuthViewModel = koinViewModel()
        LoginScreen(viewModel = viewModel, goVerification = navController::navigateToVerifyScreen)
    }
    composable(route = "${Destinations.VerifyScreen}/{mobile}", arguments = listOf(navArgument("mobile") { type = NavType.StringType })){backStackEntry ->
        val mobile = backStackEntry.arguments?.getString("mobile") ?:""
        val viewModel: AuthViewModel = koinViewModel()
        VerifyScreen(viewModel = viewModel,mobile = mobile,navUp = navController::navigateUp, goHome = {} )
    }
}

