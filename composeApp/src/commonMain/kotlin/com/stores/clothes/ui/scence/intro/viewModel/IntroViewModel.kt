package com.stores.clothes.ui.scence.intro.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stores.clothes.data.datastore.AppLocaleConfigRepo
import com.stores.clothes.data.model.intro.IntroData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class IntroViewModel  constructor(private val preferencesRepo: AppLocaleConfigRepo) : ViewModel() {

    val isFirstLaunch : Flow<Boolean> = preferencesRepo.isFirstLaunch
    val introData = IntroData.IntroList
    val appLang : Flow<String> = preferencesRepo.appLang


    fun updateIsFirstLaunch(){
        viewModelScope.launch {
            preferencesRepo.updateFirstLaunch(false)
        }
    }

    fun updateAppLang(lang:String){
        viewModelScope.launch {
            preferencesRepo.updateAppLang(lang)
        }
    }

}