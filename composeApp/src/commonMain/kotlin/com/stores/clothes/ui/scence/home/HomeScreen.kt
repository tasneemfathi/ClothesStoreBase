package com.stores.clothes.ui.scence.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.stores.clothes.ui.theme.title

@Composable
fun HomeScreen() {
    Box(modifier = Modifier.fillMaxSize(),contentAlignment = Alignment.Center){
        Text("Welcome To Home" , style = title)
    }
}