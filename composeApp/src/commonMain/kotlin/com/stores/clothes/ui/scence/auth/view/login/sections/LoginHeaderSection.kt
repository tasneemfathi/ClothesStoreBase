package com.stores.clothes.ui.scence.auth.view.login.sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import clothesappdemo.composeapp.generated.resources.Res
import clothesappdemo.composeapp.generated.resources.login
import clothesappdemo.composeapp.generated.resources.login_lbl
import clothesappdemo.composeapp.generated.resources.logo
import com.stores.clothes.ui.theme.TextGrayColor
import com.stores.clothes.ui.theme.body
import com.stores.clothes.ui.theme.bodyBold
import com.stores.clothes.ui.theme.subtitle
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun LoginHeaderSection(modifier: Modifier){
    Column (modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally){
        Image(painter = painterResource(Res.drawable.logo), contentDescription = "", modifier = Modifier.size(85.dp).align(Alignment.CenterHorizontally), contentScale = ContentScale.Fit)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = stringResource(Res.string.login), style = subtitle)
        Text(text = stringResource(Res.string.login_lbl), style = body, color = TextGrayColor, fontSize = 14.sp)
    }
}

