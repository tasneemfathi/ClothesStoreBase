package com.stores.clothes.ui.scence.auth.view.verify

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import clothesappdemo.composeapp.generated.resources.Res
import clothesappdemo.composeapp.generated.resources.empty
import com.stores.clothes.ui.core.MyAppTopBar
import com.stores.clothes.ui.scence.auth.viewModel.AuthViewModel

@ExperimentalMaterial3Api
@Composable
fun VerifyScreen(viewModel: AuthViewModel, mobile:String, navUp:()-> Unit, goHome:()->Unit){
    Scaffold(topBar = {
        MyAppTopBar(titleRes = Res.string.empty, showNavIcon = true, navUp = navUp)
    }){
        VerifyScreenContent(mobile = mobile, doVerify = goHome, resendCode = {})
    }
}