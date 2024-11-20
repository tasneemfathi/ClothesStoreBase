package com.stores.clothes

import androidx.compose.ui.window.ComposeUIViewController
import com.stores.clothes.di.KoinInitializer

fun MainViewController() = ComposeUIViewController (configure = {
    KoinInitializer().init() }){
    App()
}