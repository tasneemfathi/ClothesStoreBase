package com.stores.clothes.di

import com.stores.clothes.AppViewModel
import com.stores.clothes.ui.scence.intro.viewModel.IntroViewModel
import com.stores.clothes.ui.scence.auth.viewModel.AuthViewModel
import com.stores.clothes.ui.scence.splash.viewModel.SplashViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

//expect val viewModelModule  : Module
val viewModelModule = module {
    viewModel { AppViewModel(get()) }
    viewModel { SplashViewModel(get(),get()) }
    viewModel { IntroViewModel(get()) }
    viewModel { AuthViewModel(get()) }

}