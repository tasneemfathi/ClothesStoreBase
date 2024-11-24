package com.stores.clothes.ui.scence.auth.login.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.stores.clothes.data.networking.utils.UiState
import com.stores.clothes.ui.core.Alerter

import com.stores.clothes.ui.scence.auth.login.viewModel.LoginViewModel
import com.stores.clothes.utils.log


@Composable
fun LoginScreen(viewModel: LoginViewModel, goVerification:(String,String) -> Unit, goHome:()->Unit){
        val uiState = viewModel.authResponse.collectAsStateWithLifecycle()
        val countries = viewModel.countries.collectAsStateWithLifecycle()
        val isLoginLoading = remember { mutableStateOf(false) }
        val currentState by rememberUpdatedState(uiState.value)

        LaunchedEffect(currentState) {
                when(val state = currentState){
                        is UiState.Loading -> {
                                isLoginLoading.value = true
                        }
                        is UiState.Success -> {
                                val user = state.data
                                isLoginLoading.value = false
                                if(user.isUserEnabled) goHome()
                                else goVerification(user.countryId?.toString() ?:"",user.mobile ?:"")
                                viewModel.authResponse.value = UiState.IDLE
                        }
                        is UiState.Error-> {
                                isLoginLoading.value = false
                                Alerter.showWarningAlerter(title = "", message = state.message)
                        }
                        else->{}
                }
        }

        LoginScreenContent(viewModel.usernameField, viewModel.mobileField, isLoginLoading.value, viewModel.isFormValid.value, countries =  countries.value, doLogin = { viewModel.login() })
}