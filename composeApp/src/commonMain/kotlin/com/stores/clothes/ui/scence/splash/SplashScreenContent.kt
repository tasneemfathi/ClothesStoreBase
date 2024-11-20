package com.stores.clothes.ui.scence.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import clothesappdemo.composeapp.generated.resources.Res
import clothesappdemo.composeapp.generated.resources.header_shadow
import clothesappdemo.composeapp.generated.resources.splash_logo
import org.jetbrains.compose.resources.painterResource

@Composable
fun SplashScreenContent(scale: Animatable<Float, AnimationVector1D>) {
    Box(modifier = Modifier.fillMaxSize()){
        Image(painter = painterResource(Res.drawable.header_shadow), contentDescription = "", modifier = Modifier.fillMaxWidth().align(Alignment.TopCenter), contentScale = ContentScale.FillWidth)

        Box(modifier = Modifier.fillMaxSize().systemBarsPadding() , content = {
            Image(
                modifier = Modifier
                    .size(
                        width = 155.dp,
                        height = 184.dp
                    )
                    .align(Alignment.Center)
                    .scale(scale.value),
                painter = painterResource(Res.drawable.splash_logo),
                contentDescription = "Logo"
            )
        })
    }
}