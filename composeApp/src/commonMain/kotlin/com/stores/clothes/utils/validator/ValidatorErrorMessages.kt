package com.stores.clothes.utils.validator

import clothesappdemo.composeapp.generated.resources.Res
import clothesappdemo.composeapp.generated.resources.empty
import clothesappdemo.composeapp.generated.resources.error_empty
import clothesappdemo.composeapp.generated.resources.error_mobile_digits
import clothesappdemo.composeapp.generated.resources.error_mobile_length
import clothesappdemo.composeapp.generated.resources.error_mobile_prefix
import org.jetbrains.compose.resources.StringResource


object ErrorMessages {
    val ERROR_CODE_LENGTH    = Res.string.error_empty
    val ERROR_MOBILE_INPUT   = Res.string.error_empty
     val ERROR_MOBILE_PREFIX = Res.string.error_mobile_prefix
     val ERROR_MOBILE_LENGTH = Res.string.error_mobile_length
     val ERROR_MOBILE_DIGITS = Res.string.error_mobile_digits

}