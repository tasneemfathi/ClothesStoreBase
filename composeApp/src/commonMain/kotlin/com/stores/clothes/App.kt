package com.stores.clothes


import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.LayoutDirection
import coil3.annotation.ExperimentalCoilApi
import coil3.compose.setSingletonImageLoaderFactory
import com.stores.clothes.navigation.NavigationHost
import com.stores.clothes.ui.core.AlerterComponents
import com.stores.clothes.ui.theme.MyAppTheme
import com.stores.clothes.utils.getAsyncImageLoader
import com.stores.clothes.utils.isAppLangAr
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import org.koin.compose.viewmodel.koinViewModel


@OptIn(ExperimentalCoilApi::class)
@Composable
@Preview
fun App() {
    val mainViewModel = koinViewModel<AppViewModel>()
    val appCurrentLanguage   = mainViewModel.appLang.collectAsState(initial = "ar")

    CompositionLocalProvider(LocalLayoutDirection provides  if(isAppLangAr(appCurrentLanguage.value)) LayoutDirection.Rtl else LayoutDirection.Ltr) {
        MyAppTheme {
            PlatformColors(Color.Unspecified, Color.Unspecified)
            setSingletonImageLoaderFactory { context ->
                getAsyncImageLoader(context)
            }
            KoinContext {
                NavigationHost()
            }
        }
    }
}

