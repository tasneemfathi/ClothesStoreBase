package com.stores.clothes.utils


import platform.Foundation.NSUserDefaults


actual fun changeAppLocaleToEnglish() {
    NSUserDefaults.standardUserDefaults.setObject(arrayListOf("en"),"AppleLanguages")
}

actual fun changeAppLocaleToArabic() {
    NSUserDefaults.standardUserDefaults.setObject(arrayListOf("ar"),"AppleLanguages")
}
