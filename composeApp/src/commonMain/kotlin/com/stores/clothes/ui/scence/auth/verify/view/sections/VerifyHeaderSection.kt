package com.stores.clothes.ui.scence.auth.verify.view.sections

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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import clothesappdemo.composeapp.generated.resources.Res
import clothesappdemo.composeapp.generated.resources.logo
import clothesappdemo.composeapp.generated.resources.verify_lbl
import clothesappdemo.composeapp.generated.resources.verify_sblbl
import com.stores.clothes.ui.theme.HintColor
import com.stores.clothes.ui.theme.TextColor
import com.stores.clothes.ui.theme.body
import com.stores.clothes.ui.theme.bodyBold
import com.stores.clothes.ui.theme.subtitle
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun VerifyHeaderSection(modifier:Modifier, mobile:String){
    Column (modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(10.dp)){
        Image(painter = painterResource(Res.drawable.logo), contentDescription = "", modifier = Modifier.size(85.dp).align(Alignment.CenterHorizontally), contentScale = ContentScale.Fit)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = stringResource(Res.string.verify_lbl), style = subtitle)
        Text(buildAnnotatedString {
            append(stringResource(resource = Res.string.verify_sblbl))
            append("  ")
            withStyle(style = SpanStyle(color = TextColor, fontStyle = bodyBold.fontStyle, fontSize = 14.sp , fontWeight = FontWeight.Bold)){
                append(mobile)
            }
        }, style = body, color = HintColor, textAlign = TextAlign.Center, lineHeight = 25.sp)
    }
}