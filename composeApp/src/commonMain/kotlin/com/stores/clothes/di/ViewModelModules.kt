package com.stores.clothes.di

import com.stores.clothes.AppViewModel
import com.stores.clothes.ui.scence.intro.viewModel.IntroViewModel
import com.stores.clothes.ui.scence.auth.login.viewModel.LoginViewModel
import com.stores.clothes.ui.scence.auth.verify.viewModel.VerifyViewModel
import com.stores.clothes.ui.scence.splash.viewModel.SplashViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

//expect val viewModelModule  : Module
val viewModelModule = module {
    viewModel { AppViewModel(get()) }
    viewModel { SplashViewModel(get(),get(),get()) }
    viewModel { IntroViewModel(get()) }
    viewModel { LoginViewModel(get(), get(),get()) }
    viewModel { VerifyViewModel(get(),get()) }

}