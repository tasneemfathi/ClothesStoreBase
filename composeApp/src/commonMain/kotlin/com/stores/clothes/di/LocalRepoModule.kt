package com.stores.clothes.di

import com.stores.clothes.data.datastore.AppLocaleConfigRepo
import com.stores.clothes.data.datastore.AuthLocaleRepo
import org.koin.core.module.Module
import org.koin.dsl.module

val localRepoModule : Module  = module{
    single { AppLocaleConfigRepo(get()) }
    single { AuthLocaleRepo(get()) }
}