package com.stores.clothes.ui.core

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp

@Composable
fun OtpInputBox(
    otpLength: Int = 6,
    modifier: Modifier = Modifier,
    onOtpComplete: (String) -> Unit = {}
) {
    var otp by remember { mutableStateOf(List(otpLength) { "" }) }
    val focusRequesters = List(otpLength) { FocusRequester() }
    val focusManager = LocalFocusManager.current
    Row(
        modifier = modifier.padding(horizontal = 5.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (index in 0 until otpLength) {
            OtpCharField(
                char = otp[index],
                focusRequester = focusRequesters[index],
                onCharChange = { char ->
                    val updatedOtp = otp.toMutableList().apply { this[index] = char }
                    otp = updatedOtp

                    // Move to the next field if typing, or previous if clearing
                    if (char.isNotEmpty() && index < otpLength - 1) {
                        focusRequesters[index + 1].requestFocus()
                    } else if (char.isEmpty() && index > 0) {
                        focusRequesters[index - 1].requestFocus()
                    }

                    // If all fields are filled, complete the OTP
                    if (otp.none { it.isEmpty() }) {
                        onOtpComplete(otp.joinToString(""))
                        focusManager.clearFocus() // Clear focus once completed
                    }
                }
            )
        }
    }
}
