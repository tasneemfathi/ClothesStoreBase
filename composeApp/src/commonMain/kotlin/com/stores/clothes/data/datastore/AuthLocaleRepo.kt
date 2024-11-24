package com.stores.clothes.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.stores.clothes.data.model.auth.response.User
import com.stores.clothes.data.model.config.config.Configurations
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class AuthLocaleRepo(private val dataStore : DataStore<Preferences>){

    suspend fun accessToken() : String? = dataStore.data.firstOrNull()?.get(PreferencesKeys.authKeys)

    suspend fun updateAccessTokenLaunch(accessToken:String){
        dataStore.edit {
            it[PreferencesKeys.authKeys] = accessToken
        }
    }


    val user: Flow<User?>
        get() = dataStore.data.map {
            try{
                Json.decodeFromString(it[PreferencesKeys.userKeys] ?: "{}")
            }catch (ex:Exception){
                ex.printStackTrace()
                null
            }
        }

    suspend fun updateUser(user: User) {
        dataStore.edit {
            it[PreferencesKeys.userKeys] = Json.encodeToString(user)
        }
        if(user.accessToken.isNullOrBlank().not())
        updateAccessTokenLaunch(user.accessToken.toString())
    }

}