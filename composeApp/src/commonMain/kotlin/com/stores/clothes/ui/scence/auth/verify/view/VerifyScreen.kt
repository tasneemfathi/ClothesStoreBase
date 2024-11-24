package com.stores.clothes.ui.scence.auth.verify.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import clothesappdemo.composeapp.generated.resources.Res
import clothesappdemo.composeapp.generated.resources.empty
import com.stores.clothes.data.networking.utils.UiState
import com.stores.clothes.ui.core.Alerter
import com.stores.clothes.ui.core.MyAppTopBar
import com.stores.clothes.ui.scence.auth.login.viewModel.LoginViewModel
import com.stores.clothes.ui.scence.auth.verify.viewModel.VerifyViewModel

@ExperimentalMaterial3Api
@Composable
fun VerifyScreen(viewModel: VerifyViewModel, navUp:()-> Unit, goHome:()->Unit){
    val uiState = viewModel.verifyResponse.collectAsStateWithLifecycle()
    val uiStateResend = viewModel.resendResponse.collectAsStateWithLifecycle()
    val isLoading = remember { mutableStateOf(false) }

    when(val state = uiState.value){
        is UiState.Loading -> {
            isLoading.value = true
        }
        is UiState.Success -> {
            isLoading.value = false
            goHome()
        }
        is UiState.Error-> {
            isLoading.value = false
            Alerter.showWarningAlerter(title = "", message = state.message)
        }
        else->{}
    }


    when(val state = uiStateResend.value){
        is UiState.Success -> {
            Alerter.showSuccessAlerter(title = "", message = state.data)

        }
        is UiState.Error-> {
            Alerter.showWarningAlerter(title = "", message = state.message)
        }
        else->{}
    }

    Scaffold(topBar = {
        MyAppTopBar(titleRes = Res.string.empty, showNavIcon = true, navUp = navUp)
    }){
        VerifyScreenContent(mobile = viewModel.mobile, code = viewModel.verificationCode, isButtonLoading = isLoading.value, isButtonEnabled = viewModel.isFormValid.value, doVerify = viewModel::verify, resendCode = viewModel::resend)
    }
}