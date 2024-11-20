package com.stores.clothes.ui.scence.intro.view.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.stores.clothes.ui.theme.HintColor
import com.stores.clothes.ui.theme.LightGrayColor
import com.stores.clothes.ui.theme.Primary

@Composable
fun IndicatorSection(count:Int, selectedIndex:Int){
    LazyRow(modifier = Modifier, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        items(count){index -> Int
            IndicatorItem(isSelected = index == selectedIndex)
        }
    }
}

@Composable
fun IndicatorItem(isSelected:Boolean){
    Box(modifier = Modifier.width(if(isSelected) 30.dp else 15.dp).height(4.dp).background(color = if(isSelected) Primary else LightGrayColor , shape = RoundedCornerShape(30.dp))){}
}