package com.stores.clothes.ui.scence.intro.view.sections

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import clothesappdemo.composeapp.generated.resources.Res
import clothesappdemo.composeapp.generated.resources.lets_start
import clothesappdemo.composeapp.generated.resources.next
import clothesappdemo.composeapp.generated.resources.skip
import com.stores.clothes.ui.core.MyAppButton
import com.stores.clothes.ui.theme.PaddingHorizontal
import com.stores.clothes.ui.theme.bodyBold
import com.stores.clothes.utils.noRippleClickable
import org.jetbrains.compose.resources.stringResource

@Composable
fun IntroActions(currentIndex:Int, next:()->Unit, skip:()-> Unit){
    Row (modifier = Modifier.fillMaxWidth()
        .padding(horizontal = PaddingHorizontal)
        .padding(bottom = 15.dp)
        .height(50.dp)){
        MyAppButton(onClick = next, title =  if(currentIndex == 2) stringResource(resource = Res.string.lets_start) else stringResource(resource = Res.string.next) , modifier = Modifier.fillMaxHeight().weight(1f))
        if(currentIndex != 2) {
            Box(modifier = Modifier.fillMaxHeight().weight(1f)){
                Text(
                    modifier = Modifier.align(Alignment.Center).noRippleClickable { skip() },
                    text = stringResource(Res.string.skip),
                    style = bodyBold,
                )
            }

        }
    }
}