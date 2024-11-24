package com.stores.clothes.navigation.auth

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.stores.clothes.navigation.Destinations
import com.stores.clothes.navigation.home.navigateToHomeScreen
import com.stores.clothes.ui.scence.auth.login.view.LoginScreen
import com.stores.clothes.ui.scence.auth.verify.view.VerifyScreen
import com.stores.clothes.ui.scence.auth.login.viewModel.LoginViewModel
import com.stores.clothes.ui.scence.auth.verify.viewModel.VerifyViewModel
import org.koin.compose.viewmodel.koinViewModel


@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.authNavigationHost(navController: NavHostController) {
    composable(route = Destinations.LoginScreen.toString()){
        val viewModel: LoginViewModel = koinViewModel()
        LoginScreen(viewModel = viewModel, goVerification = navController::navigateToVerifyScreen, goHome = navController::navigateToHomeScreen)
    }
    composable(route = "${Destinations.VerifyScreen}/{countryId}/{mobile}", arguments = listOf(navArgument("mobile") { type = NavType.StringType })){backStackEntry ->
        val countryId = backStackEntry.arguments?.getString("countryId") ?:""
        val mobile = backStackEntry.arguments?.getString("mobile") ?:""
        val viewModel: VerifyViewModel = koinViewModel()
        viewModel.mobile = mobile
        viewModel.countryId = countryId
        VerifyScreen(viewModel = viewModel,navUp = navController::navigateUp, goHome = navController::navigateToHomeScreen )
    }
}

