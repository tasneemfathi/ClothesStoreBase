package com.stores.clothes.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import okio.Path.Companion.toPath


fun createDataStore(producePath: () -> String): DataStore<Preferences> {
    return PreferenceDataStoreFactory.createWithPath(
        produceFile = { producePath().toPath() }
    )
}

internal const val DATA_STORE_FILE_NAME = "prefs.preferences_pb"
internal const val DATA_STORE_CONFIG = "config_key"
internal const val DATA_STORE_USER = "user_key"
internal const val DATA_STORE_COUNTRIES = "countries_key"
internal const val DATA_STORE_FIRST_LAUNCH = "is_first_launch"
internal const val DATA_STORE_LANG = "lang_key"
internal const val DATA_STORE_AUTH_TOKEN = "auth_token"

object PreferencesKeys {
    val authKeys = stringPreferencesKey(DATA_STORE_AUTH_TOKEN)
    val userKeys = stringPreferencesKey(DATA_STORE_USER)
    val configKeys = stringPreferencesKey(DATA_STORE_CONFIG)
    val countriesKeys = stringPreferencesKey(DATA_STORE_COUNTRIES)
    val firstLaunchKeys = booleanPreferencesKey(DATA_STORE_FIRST_LAUNCH)
    val langKeys = stringPreferencesKey(DATA_STORE_LANG)
}