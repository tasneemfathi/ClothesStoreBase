package com.stores.clothes.di

import com.stores.clothes.data.networking.client.createHttpClient
import com.stores.clothes.data.networking.repo.AuthRepo
import com.stores.clothes.data.networking.repo.ConfigRepo
import org.koin.dsl.module

val networkModule = module {
    single { createHttpClient(get()) }
    single { AuthRepo(get()) }
    single { ConfigRepo(get()) }
}