package com.stores.clothes.utils.validator


import org.jetbrains.compose.resources.StringResource
object Validators {
    fun validateRequired(input: String): StringResource? {
        return when {
            input.isEmpty() ->  ErrorMessages.ERROR_MOBILE_INPUT
            else -> null
        }
    }

    fun validateMobile(mobile: String): StringResource? {
        return when {
            mobile.isEmpty() -> ErrorMessages.ERROR_MOBILE_INPUT
            !mobile.startsWith("5") -> ErrorMessages.ERROR_MOBILE_PREFIX
            mobile.length != 9 -> ErrorMessages.ERROR_MOBILE_LENGTH
            !mobile.all { it.isDigit() } -> ErrorMessages.ERROR_MOBILE_DIGITS
            else -> null
        }
    }

    fun validateCode(input: String): StringResource? {
        return when {
            input.length == 4 ->  null
            else -> ErrorMessages.ERROR_CODE_LENGTH
        }
    }

}