package com.stores.clothes.ui.core

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import clothesappdemo.composeapp.generated.resources.Res
import clothesappdemo.composeapp.generated.resources.flag
import clothesappdemo.composeapp.generated.resources.ic_drop_down
import com.stores.clothes.data.model.config.CountryModel
import com.stores.clothes.ui.theme.PlaceHolderColor
import com.stores.clothes.ui.theme.TextColor
import com.stores.clothes.ui.theme.body
import com.stores.clothes.ui.theme.bodyMedium
import com.stores.clothes.utils.noRippleClickable
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryCodeDropDown(modifier: Modifier, focusRequester: FocusRequester){
    var selectedOption by remember { mutableStateOf<CountryModel>(CountryModel.CountryCodeList.first()) }
    var expanded by remember { mutableStateOf(false) }
    Row(
        modifier = modifier.background(
            shape = RoundedCornerShape(10.dp),
            color = PlaceHolderColor
        ), horizontalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        Spacer(
            modifier = Modifier
                .width(1.dp)
                .height(20.dp)
                .background(color = PlaceHolderColor)
        )
        ExposedDropdownMenuBox(
            modifier = Modifier,
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {

            Row(modifier = modifier.padding(horizontal = 7.dp),
                verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                Icon(painter = painterResource(resource = Res.drawable.ic_drop_down), tint = Color.Unspecified, contentDescription = "", modifier = Modifier.width(10.dp).height(6.dp))
                Text(
                    text = selectedOption.countryCode,
                    style = bodyMedium,
                    color = TextColor,
                    modifier = Modifier.menuAnchor(type = MenuAnchorType.PrimaryEditable, enabled = true).noRippleClickable {
                        focusRequester.requestFocus()
                        expanded = true
                    }
                )
                Image(
                    painter = painterResource(resource = Res.drawable.flag),
                    modifier = Modifier
                        .width(width = 24.dp)
                        .height(20.dp)
                        .clip(RoundedCornerShape(CornerSize(10.dp))),
                    contentDescription = ""
                )
            }


            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                    //  focusManager.clearFocus()
                },
                modifier = Modifier.focusRequester(focusRequester).background(color = Color.White)) {
                CountryModel.CountryCodeList.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option.countryCode, style = body, color = TextColor) },
                        onClick = {
                            selectedOption = option
                            expanded = false // Close the dropdown
                        }
                    )
                }
            }
        }
    }


}