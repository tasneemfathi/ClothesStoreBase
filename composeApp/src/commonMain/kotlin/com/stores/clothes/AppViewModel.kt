package com.stores.clothes

import androidx.lifecycle.ViewModel
import com.stores.clothes.data.datastore.AppLocaleConfigRepo

import kotlinx.coroutines.flow.Flow

class AppViewModel(appConfigRepo: AppLocaleConfigRepo):
    ViewModel(){
    val appLang : Flow<String> = appConfigRepo.appLang

}