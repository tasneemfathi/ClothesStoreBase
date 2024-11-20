package com.stores.clothes.data.networking.client

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.stores.clothes.data.datastore.PreferencesKeys
import kotlinx.coroutines.flow.firstOrNull

class TokenLocaleStorage(private val dataStore : DataStore<Preferences>){

    suspend fun accessToken() : String? = dataStore.data.firstOrNull()?.get(PreferencesKeys.authKeys)

    suspend fun updateFirstLaunch(accessToken:String){
        dataStore.edit {
            it[PreferencesKeys.authKeys] = accessToken
        }
    }

}