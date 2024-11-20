package com.stores.clothes.ui.core

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import com.stores.clothes.ui.theme.body
import com.stores.clothes.utils.formatDecimal
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun TimerComponent(
    modifier: Modifier,
    isRunning:MutableState<Boolean>,
    totalTimeInSeconds: Long = 30L,
){
    var timeLeft by remember { mutableStateOf(totalTimeInSeconds) }
    val coroutineScope = rememberCoroutineScope()

    val minutes = timeLeft / 60
    val seconds = timeLeft % 60
    val formattedTime = "${formatDecimal(minutes.toDouble())}:${formatDecimal(seconds.toDouble())}"

    LaunchedEffect(isRunning.value) {
        if (isRunning.value) {
            coroutineScope.launch {
                while (isRunning.value) {
                    if(timeLeft > 0){
                        delay(1000L) // Delay 1 second
                        timeLeft -= 1
                    }else{
                        isRunning.value = false
                    }
                }
                timeLeft = totalTimeInSeconds
            }
        }
    }

    Text(
        text = formattedTime,
        style = body,
        textAlign = TextAlign.Center,
        modifier = modifier, textDecoration = TextDecoration.Underline
    )

}