package com.stores.clothes.ui.scence.auth.view.verify

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import clothesappdemo.composeapp.generated.resources.Res
import clothesappdemo.composeapp.generated.resources.header_shadow
import com.stores.clothes.ui.scence.auth.view.verify.sections.VerifyActionSection
import com.stores.clothes.ui.scence.auth.view.verify.sections.VerifyFormSection
import com.stores.clothes.ui.scence.auth.view.verify.sections.VerifyHeaderSection
import com.stores.clothes.ui.theme.PaddingHorizontal
import org.jetbrains.compose.resources.painterResource

@Composable
fun VerifyScreenContent(mobile:String,doVerify:()->Unit,resendCode:()->Unit){
    val isRunning = remember { mutableStateOf(true) }
    Box(modifier = Modifier.fillMaxSize()){
        Image(painter = painterResource(Res.drawable.header_shadow), contentDescription = "", modifier = Modifier.fillMaxWidth().align(
            Alignment.TopEnd), contentScale = ContentScale.FillWidth)
        Column (modifier = Modifier.fillMaxSize().systemBarsPadding().padding(top = 40.dp).padding(horizontal = PaddingHorizontal), verticalArrangement = Arrangement.spacedBy(30.dp), horizontalAlignment = Alignment.CenterHorizontally){
            VerifyHeaderSection(modifier = Modifier , mobile = mobile)
            VerifyFormSection(modifier = Modifier, isRunning = isRunning, resendCode = resendCode)
            VerifyActionSection(modifier = Modifier, goVerify = doVerify)
        }
    }
}