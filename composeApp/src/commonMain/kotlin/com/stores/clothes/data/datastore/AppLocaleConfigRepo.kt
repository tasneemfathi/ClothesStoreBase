package com.stores.clothes.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AppLocaleConfigRepo(private val dataStore : DataStore<Preferences>){

    val isFirstLaunch : Flow<Boolean>
        get() = dataStore.data.map {
            it[PreferencesKeys.firstLaunchKeys] ?: true
        }

    suspend fun updateFirstLaunch(isFirstLaunch:Boolean){
        dataStore.edit {
            it[PreferencesKeys.firstLaunchKeys] = isFirstLaunch
        }
    }


    val appLang: Flow<String>
        get() = dataStore.data.map { it[PreferencesKeys.langKeys] ?: "ar" }

    suspend fun updateAppLang(lang: String) {
        dataStore.edit {
            it[PreferencesKeys.langKeys] = lang
        }
    }
}