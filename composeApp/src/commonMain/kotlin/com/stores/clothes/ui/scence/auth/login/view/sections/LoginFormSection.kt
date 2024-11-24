package com.stores.clothes.ui.scence.auth.login.view.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.unit.dp
import clothesappdemo.composeapp.generated.resources.Res
import clothesappdemo.composeapp.generated.resources.ic_mobile
import clothesappdemo.composeapp.generated.resources.ic_user
import clothesappdemo.composeapp.generated.resources.login_verify
import clothesappdemo.composeapp.generated.resources.mobile
import clothesappdemo.composeapp.generated.resources.username
import com.stores.clothes.data.model.config.countries.Country
import com.stores.clothes.ui.core.CountryCodeDropDown
import com.stores.clothes.ui.core.MyTextField
import com.stores.clothes.ui.theme.TextGrayColor
import com.stores.clothes.ui.theme.body
import com.stores.clothes.utils.wrapper.InputWrapper
import org.jetbrains.compose.resources.stringResource

@Composable
fun LoginFormSection(
    modifier: Modifier,
    username: InputWrapper,
    mobile: InputWrapper,
    countries: List<Country>
){
    val focusRequester = remember { FocusRequester() }

    Column (modifier = modifier, verticalArrangement = Arrangement.spacedBy(10.dp), horizontalAlignment = Alignment.Start){
        MyTextField(modifier = Modifier.fillMaxWidth(),iconRes = Res.drawable.ic_user, label = stringResource(Res.string.username), text = username, errorMessageRes = username.errorMessage.value)
        Row (modifier = Modifier, horizontalArrangement = Arrangement.spacedBy(5.dp), verticalAlignment = Alignment.Top){
            CountryCodeDropDown(modifier = Modifier.height(60.dp), focusRequester = focusRequester,countries = countries)
            MyTextField(Modifier.weight(1f),iconRes = Res.drawable.ic_mobile, label = stringResource(Res.string.mobile), text = mobile, errorMessageRes = mobile.errorMessage.value, focusRequester = focusRequester)
        }
        Text(text =  stringResource(Res.string.login_verify), style = body, color = TextGrayColor)
    }
}