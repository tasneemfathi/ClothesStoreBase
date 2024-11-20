package com.stores.clothes.ui.scence.intro.view.sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import clothesappdemo.composeapp.generated.resources.Res
import clothesappdemo.composeapp.generated.resources.ic_lang
import com.stores.clothes.ui.theme.PaddingHorizontal
import com.stores.clothes.ui.theme.onPrimary
import com.stores.clothes.utils.noRippleClickable
import org.jetbrains.compose.resources.painterResource

@Composable
fun LangSwitcherSection(switchLang:()->Unit){
    Row (modifier = Modifier.fillMaxWidth().padding(horizontal = PaddingHorizontal).padding(top = 15.dp)){
        Spacer(Modifier.weight(1f))
        Box(modifier = Modifier.noRippleClickable { switchLang() }.size(40.dp,40.dp).background(color = onPrimary, shape = RoundedCornerShape(12.dp))){
            Image(painter = painterResource(Res.drawable.ic_lang), contentDescription = "Switch Language", modifier = Modifier.size(20.dp).align(
                Alignment.Center))
        }
    }
}