package com.stores.clothes.data.model.intro

import clothesappdemo.composeapp.generated.resources.Res
import clothesappdemo.composeapp.generated.resources.intro1
import clothesappdemo.composeapp.generated.resources.intro2
import clothesappdemo.composeapp.generated.resources.intro3
import clothesappdemo.composeapp.generated.resources.introDesc1
import clothesappdemo.composeapp.generated.resources.introDesc2
import clothesappdemo.composeapp.generated.resources.introDesc3
import clothesappdemo.composeapp.generated.resources.introTitle1
import clothesappdemo.composeapp.generated.resources.introTitle2
import clothesappdemo.composeapp.generated.resources.introTitle3
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource


data class IntroData(val titleRes:StringResource, val descriptionRes:StringResource, val imageRes: DrawableResource){
    companion object{
        private val Example1 = IntroData(titleRes = Res.string.introTitle1, descriptionRes = Res.string.introDesc1, imageRes = Res.drawable.intro1)
        private val Example2 = IntroData(titleRes = Res.string.introTitle2, descriptionRes = Res.string.introDesc2, imageRes = Res.drawable.intro2)
        private val Example3 = IntroData(titleRes = Res.string.introTitle3, descriptionRes = Res.string.introDesc3, imageRes = Res.drawable.intro3)
        val IntroList : List<IntroData> = listOf(Example1, Example2, Example3)
    }
}


