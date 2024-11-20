package com.stores.clothes.ui.scence.auth.view.login.sections

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import clothesappdemo.composeapp.generated.resources.Res
import clothesappdemo.composeapp.generated.resources.send_verification
import com.stores.clothes.ui.core.MyAppButton
import org.jetbrains.compose.resources.stringResource

@Composable
fun LoginActionSection(
    modifier: Modifier,
    isLoginButtonLoading: Boolean,
    isLoginButtonEnabled: Boolean,
    doLogin: () -> Unit
){
    MyAppButton(modifier = modifier.fillMaxWidth(), onClick = doLogin, title =  stringResource(resource = Res.string.send_verification) , isEnabled = isLoginButtonEnabled, isLoading = isLoginButtonLoading)
}