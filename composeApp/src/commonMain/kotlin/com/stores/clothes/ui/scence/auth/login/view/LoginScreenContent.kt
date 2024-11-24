package com.stores.clothes.ui.scence.auth.login.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import clothesappdemo.composeapp.generated.resources.Res
import clothesappdemo.composeapp.generated.resources.header_shadow
import com.stores.clothes.data.model.config.countries.Country
import com.stores.clothes.ui.scence.auth.login.view.sections.LoginActionSection
import com.stores.clothes.ui.scence.auth.login.view.sections.LoginFormSection
import com.stores.clothes.ui.scence.auth.login.view.sections.LoginHeaderSection
import com.stores.clothes.ui.theme.PaddingHorizontal
import com.stores.clothes.utils.wrapper.InputWrapper
import org.jetbrains.compose.resources.painterResource

@Composable
fun LoginScreenContent(
    username: InputWrapper,
    mobile: InputWrapper,
    isLoginButtonLoading: Boolean,
    isLoginButtonEnabled: Boolean,
    countries: List<Country>,
    doLogin: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()){
        Image(painter = painterResource(Res.drawable.header_shadow), contentDescription = "", modifier = Modifier.fillMaxWidth().align(Alignment.TopEnd), contentScale = ContentScale.FillWidth)
        Column (modifier = Modifier.fillMaxSize().systemBarsPadding().padding(top = 40.dp).padding(horizontal = PaddingHorizontal), verticalArrangement = Arrangement.spacedBy(10.dp), horizontalAlignment = Alignment.CenterHorizontally){
            LoginHeaderSection(modifier = Modifier)
            Spacer(Modifier.height(20.dp))
            LoginFormSection(modifier= Modifier,username,mobile,countries)
            Spacer(Modifier.height(20.dp))
            LoginActionSection(modifier = Modifier,isLoginButtonEnabled = isLoginButtonEnabled, isLoginButtonLoading = isLoginButtonLoading,doLogin = doLogin)
        }
    }

}