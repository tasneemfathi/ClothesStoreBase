package com.stores.clothes.ui.scence.auth.view.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.stores.clothes.data.networking.utils.UiState
import com.stores.clothes.ui.core.Alerter

import com.stores.clothes.ui.scence.auth.viewModel.AuthViewModel


@Composable
fun LoginScreen(viewModel: AuthViewModel, goVerification:(String) -> Unit){
        val uiState = viewModel.authResponse.collectAsStateWithLifecycle()
        val isLoginLoading = remember { mutableStateOf(false) }

        when(val state = uiState.value){
                is UiState.Loading -> {
                        isLoginLoading.value = true
                }
                is UiState.Success -> {
                        isLoginLoading.value = false
                        goVerification(viewModel.mobileField.value)
                }
                is UiState.Error-> {
                        isLoginLoading.value = false
                        Alerter.showWarningAlerter(title = state.message, message = "Your subscription will expire soon!")
                }
                else->{}
        }

        LoginScreenContent(viewModel.usernameField, viewModel.mobileField, isLoginLoading.value, viewModel.isFormValid.value, doLogin = { viewModel.login() })
}