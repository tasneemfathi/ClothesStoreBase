package com.stores.clothes.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.stores.clothes.data.model.config.config.Configurations
import com.stores.clothes.data.model.config.countries.Country
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

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



    val config: Flow<Configurations?>
        get() = dataStore.data.map {
            try{
                Json.decodeFromString(it[PreferencesKeys.configKeys] ?: "{}")
            }catch (ex:Exception){
                ex.printStackTrace()
                null
            }
        }

    suspend fun updateAppConfig(config: Configurations) {
        dataStore.edit {
            it[PreferencesKeys.configKeys] = Json.encodeToString(config)
        }
    }

    val countries: Flow<List<Country>>
        get() = dataStore.data.map {
            try{
                Json.decodeFromString(it[PreferencesKeys.countriesKeys] ?: "{}")
            }catch (ex:Exception){
                ex.printStackTrace()
                listOf()
            }
        }

    suspend fun updateAppCountries(countries: List<Country>) {
        dataStore.edit {
            it[PreferencesKeys.countriesKeys] = Json.encodeToString(countries)
        }
    }

}