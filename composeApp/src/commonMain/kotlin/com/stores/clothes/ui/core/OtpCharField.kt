package com.stores.clothes.ui.core

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stores.clothes.ui.theme.CornerRadius
import com.stores.clothes.ui.theme.PlaceHolderColor
import com.stores.clothes.ui.theme.title


@Composable
fun OtpCharField(
    char: String,
    focusRequester: FocusRequester,
    onCharChange: (String) -> Unit) {
    var isFocused by remember { mutableStateOf(false) }

    Box(Modifier
        .size(width = 80.dp, height = 60.dp)
        .background(
            color = PlaceHolderColor,
            shape = RoundedCornerShape(size = CornerRadius)
        )
    , contentAlignment = Alignment.Center){
        BasicTextField(
            value = char,
            onValueChange = { newChar ->
                if (newChar.length <= 1) {
                    onCharChange(newChar)
                }
            },
            modifier = Modifier
                .focusRequester(focusRequester) // Attach FocusRequester here
                .onFocusChanged { focusState ->
                    isFocused =focusState.isFocused

                },
            textStyle = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        ) { innerTextField ->
                innerTextField()
        }
    }


}