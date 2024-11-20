package com.stores.clothes.utils

import android.app.Application
import android.app.LocaleManager
import android.content.Context
import android.os.Build
import android.os.LocaleList
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import com.stores.clothes.MyAppBase
import java.util.Locale


actual fun changeAppLocaleToEnglish() {
    MyAppBase.getAppContext().setLocale("en")
}

actual fun changeAppLocaleToArabic() {
    MyAppBase.getAppContext().setLocale("ar")
}

fun Context.setLocale(lang: String) {
    this.getSharedPreferences("app_preferences", Application.MODE_PRIVATE).edit().putBoolean("is_first_time", false).apply()
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        this.getSystemService(LocaleManager::class.java)
            .applicationLocales = LocaleList(Locale.forLanguageTag(lang))
    } else {
        AppCompatDelegate.setApplicationLocales(
            LocaleListCompat.forLanguageTags(lang)
        )
    }
}