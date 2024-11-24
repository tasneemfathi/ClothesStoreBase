package com.stores.clothes.ui.scence.intro.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.stores.clothes.ui.scence.intro.viewModel.IntroViewModel
import com.stores.clothes.utils.switchAppLang
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun IntroScreen(onFinish:()->Unit){
    val viewModel: IntroViewModel = koinViewModel<IntroViewModel>()
    val currentAppLang = viewModel.appLang.collectAsState("ar")
    IntroScreenContent(
        viewModel,
        switchLang = { switchAppLang(currentAppLang, updateAppLang = viewModel::updateAppLang) },
        onFinish = {
            viewModel.updateIsFirstLaunch()
            onFinish()
        }
    )
}

