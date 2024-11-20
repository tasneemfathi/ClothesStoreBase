package com.stores.clothes.ui.core

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

@ExperimentalMaterial3Api
@Composable
fun MyAppTopBar(titleRes:StringResource, showNavIcon:Boolean = false, navUp:() -> Unit = {},actions: @Composable RowScope.() -> Unit = {}){
    TopAppBar(
        modifier = Modifier.padding(horizontal = 16.dp),
        colors = TopAppBarColors(
            containerColor = Color.Unspecified,
            actionIconContentColor = Color.Unspecified,
            navigationIconContentColor = Color.Unspecified,
            scrolledContainerColor = Color.Unspecified,
            titleContentColor = Color.Unspecified
        ),
        title = {
            Text(text = stringResource(titleRes))
        },
        navigationIcon = { if(showNavIcon) NavBackIcon(navUp = navUp) },
        actions = actions
    )
}