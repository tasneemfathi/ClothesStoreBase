package com.stores.clothes.utils

import platform.Foundation.NSNumber
import platform.Foundation.NSNumberFormatter
import platform.Foundation.NSNumberFormatterDecimalStyle
import platform.Foundation.NSNumberFormatterNoStyle
import platform.Foundation.NSNumberFormatterStyle

actual fun formatDecimal(number: Double): String {
    val numberFormatter = NSNumberFormatter()
    numberFormatter.numberStyle = NSNumberFormatterNoStyle
    numberFormatter.minimumIntegerDigits = 1u
    numberFormatter.maximumIntegerDigits = 2u
    return numberFormatter.stringFromNumber(NSNumber(number)) ?: ""
}