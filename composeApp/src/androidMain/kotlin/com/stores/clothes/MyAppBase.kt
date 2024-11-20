package com.stores.clothes

import AppContext
import android.app.Application
import android.content.Context
import com.stores.clothes.di.KoinInitializer


class MyAppBase: Application() {
    companion object {
        lateinit var instance: MyAppBase
            private set

        fun getAppContext(): Context = instance.applicationContext
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
        KoinInitializer(applicationContext).init()
        AppContext.setUp(applicationContext)
    }
}