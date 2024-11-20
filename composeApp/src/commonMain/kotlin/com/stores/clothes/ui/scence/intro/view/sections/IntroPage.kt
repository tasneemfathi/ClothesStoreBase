package com.stores.clothes.ui.scence.intro.view.sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stores.clothes.data.model.intro.IntroData
import com.stores.clothes.ui.theme.HintColor
import com.stores.clothes.ui.theme.PaddingHorizontal
import com.stores.clothes.ui.theme.body
import com.stores.clothes.ui.theme.subtitle
import com.stores.clothes.ui.theme.title
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun IntroPage(data: IntroData){
    Column( modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = PaddingHorizontal),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(data.imageRes),contentDescription = "Intro Image", modifier = Modifier   .size(width = 353.dp, height = 302.dp))

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = stringResource(resource = data.titleRes), style = subtitle, textAlign = TextAlign.Center, fontSize = 16.sp
        )
        Text(
            text = stringResource(resource = data.descriptionRes),
            style = body, color = HintColor, textAlign = TextAlign.Center, fontSize = 14.sp
        )
    }
}