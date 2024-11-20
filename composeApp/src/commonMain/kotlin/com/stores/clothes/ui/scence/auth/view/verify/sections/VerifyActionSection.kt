package com.stores.clothes.ui.scence.auth.view.verify.sections

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import clothesappdemo.composeapp.generated.resources.Res
import clothesappdemo.composeapp.generated.resources.send
import com.stores.clothes.ui.core.MyAppButton
import org.jetbrains.compose.resources.stringResource

@Composable
fun VerifyActionSection(modifier: Modifier, goVerify:()->Unit){
    MyAppButton(modifier = modifier.fillMaxWidth(), onClick = goVerify, title =  stringResource(resource = Res.string.send) )

}