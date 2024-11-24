package com.stores.clothes.ui.scence.auth.verify.view.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import clothesappdemo.composeapp.generated.resources.Res
import clothesappdemo.composeapp.generated.resources.resendCode
import com.stores.clothes.ui.core.OtpInputBox
import com.stores.clothes.ui.core.TimerComponent
import com.stores.clothes.ui.theme.HintColor
import com.stores.clothes.ui.theme.Primary
import com.stores.clothes.ui.theme.body
import com.stores.clothes.utils.noRippleClickable
import com.stores.clothes.utils.wrapper.InputWrapper
import org.jetbrains.compose.resources.stringResource

@Composable
fun VerifyFormSection(
    modifier: Modifier,
    isRunning: MutableState<Boolean>,
    resendCode: () -> Unit,
    code: InputWrapper
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(25.dp)
    ) {
        OtpInputBox(
            otpLength = 4,
            onOtpComplete = { otp ->
                // Do something with the OTP (e.g., send to backend)
                code.onValueChanged(otp)
            }
        )

        TimerComponent(modifier = Modifier, isRunning = isRunning)

        Text(
            text = stringResource(resource = Res.string.resendCode),
            style = body,
            color = if(isRunning.value) HintColor else Primary,
            modifier = Modifier.noRippleClickable { if(!isRunning.value){
                isRunning.value = !isRunning.value
                resendCode()
            }},
            textDecoration = TextDecoration.Underline
        )
    }
}