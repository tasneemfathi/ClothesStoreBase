package com.stores.clothes.data.model.config

import clothesappdemo.composeapp.generated.resources.Res
import clothesappdemo.composeapp.generated.resources.flag
import org.jetbrains.compose.resources.DrawableResource


data class CountryModel(val id:Int,val countryCode:String, val iconRes:DrawableResource){
    companion object{
        private val Example1 = CountryModel(id = 1, countryCode = "+966", iconRes = Res.drawable.flag)
        private val Example2 = CountryModel(id = 2, countryCode = "+966", iconRes = Res.drawable.flag)

        val CountryCodeList = listOf(Example1,Example2)
    }
}