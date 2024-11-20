package com.stores.clothes.utils.wrapper

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import clothesappdemo.composeapp.generated.resources.Res
import clothesappdemo.composeapp.generated.resources.empty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import org.jetbrains.compose.resources.StringResource

class InputWrapper(
    initialValue: String = "",
    private val validator: (String) -> StringResource? // Validation function
) {
    var value by mutableStateOf(initialValue)
        private set
    var errorMessage = MutableStateFlow<StringResource?>(null)
        private set

    fun onValueChanged(newValue: String) {
        value = newValue
        errorMessage.value = validator(newValue)
    }

    val isValid: StateFlow<Boolean> = errorMessage.map { it == null }.stateIn(
        scope = CoroutineScope(Dispatchers.Default),
        started = SharingStarted.Lazily,
        initialValue = false
    )
}