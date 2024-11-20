package com.stores.clothes.di

import com.stores.clothes.datastore.createDataStore
import org.koin.core.module.Module
import org.koin.dsl.module

actual val DataStorePreferencesModule: Module = module {
    single { createDataStore() }
}
