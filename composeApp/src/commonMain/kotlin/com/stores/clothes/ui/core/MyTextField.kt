package com.stores.clothes.ui.core

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.stores.clothes.ui.theme.HintColor
import com.stores.clothes.ui.theme.PlaceHolderColor
import com.stores.clothes.ui.theme.body
import com.stores.clothes.utils.wrapper.InputWrapper
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun MyTextField(modifier: Modifier ,iconRes: DrawableResource? = null, label:String, text:InputWrapper,errorMessageRes:StringResource? = null, maxLine:Int = 1, keyboardType:KeyboardType = KeyboardType.Text, focusRequester: FocusRequester = remember { FocusRequester() }){
    Column (modifier.wrapContentHeight()){
        Row(
            modifier = Modifier.fillMaxWidth()
                .height(60.dp)
                .background(shape = RoundedCornerShape(10.dp), color = PlaceHolderColor)
                .border(1.dp, color = if(text.isValid.value.not()) MaterialTheme.colorScheme.error else Color.Unspecified  , shape = RoundedCornerShape(10.dp))
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(3.dp)
        ) {
            iconRes?.let {
                Icon(
                    painter = painterResource(iconRes),
                    tint = if(text.isValid.value.not()) MaterialTheme.colorScheme.error else Color.Unspecified,
                    contentDescription = label,
                )
            }

            TextField(
                value = text.value,
                onValueChange = { text.onValueChanged(it) },
                label = { Text(text = label, style = body, color = HintColor) },
                    modifier = Modifier
                    .weight(1f)
                    .focusRequester(focusRequester),
                     colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                minLines = maxLine,
                maxLines = maxLine,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = keyboardType
                ),

            )


        }
        errorMessageRes?.apply {
            Text(
                modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(horizontal = 16.dp),
                text = stringResource(this),
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }

}