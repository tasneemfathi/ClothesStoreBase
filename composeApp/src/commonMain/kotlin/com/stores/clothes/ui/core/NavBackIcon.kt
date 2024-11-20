package com.stores.clothes.ui.core

import androidx.compose.foundation.clickable
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import clothesappdemo.composeapp.generated.resources.Res
import clothesappdemo.composeapp.generated.resources.ic_back_arrow
import org.jetbrains.compose.resources.painterResource

@Composable
fun NavBackIcon(navUp:() -> Unit){
    Icon(painter = painterResource( Res.drawable.ic_back_arrow), contentDescription = "Go Back" , modifier = Modifier.clickable {  navUp()} )
}