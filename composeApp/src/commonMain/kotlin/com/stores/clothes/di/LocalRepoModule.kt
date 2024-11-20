package com.stores.clothes.di

import com.stores.clothes.data.datastore.AppLocaleConfigRepo
import com.stores.clothes.data.networking.client.TokenLocaleStorage
import org.koin.core.module.Module
import org.koin.dsl.module

val localRepoModule : Module  = module{
    single { AppLocaleConfigRepo(get()) }
    single { TokenLocaleStorage(get()) }
}