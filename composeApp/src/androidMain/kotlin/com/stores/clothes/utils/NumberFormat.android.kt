package com.stores.clothes.utils

import java.text.DecimalFormat

actual fun formatDecimal(number: Double): String {
    val formatter = DecimalFormat("00")
    return formatter.format(number)
}