package com.stores.clothes.ui.core

import Alerter
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import clothesappdemo.composeapp.generated.resources.Res
import clothesappdemo.composeapp.generated.resources.ic_success
import clothesappdemo.composeapp.generated.resources.warning_icon
import com.stores.clothes.ui.core.Alerter.Companion.isVisibleSuccess
import com.stores.clothes.ui.core.Alerter.Companion.isVisibleWarning
import org.jetbrains.compose.resources.painterResource
import kotlin.jvm.JvmStatic

class Alerter{
    companion object{
        fun showWarningAlerter(title: String,message: String){
            this.title.value = title
            this.message.value = message
            isVisibleWarning.value = true

        }
        fun showSuccessAlerter(title: String,message: String){
            this.title.value = title
            this.message.value = message
            isVisibleSuccess.value = true

        }
        var isVisibleWarning = mutableStateOf(false)
        var isVisibleSuccess = mutableStateOf(false)
        var title = mutableStateOf("")
        var message = mutableStateOf("")
    }
}

@Composable
fun AlerterComponents(){

    Alerter(
        isVisible = isVisibleWarning.value, alertStyle = AlertStyle.Standard,
        onChanged = { isVisibleWarning.value = it }, enableDismissWhenAlertClick = false,
        backgroundColor = Color.Red
    ) {
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Row(
                modifier =
                Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .clip(RoundedCornerShape(16.dp))
                    .padding(horizontal = 16.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier =
                    Modifier
                        .size(38.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .padding(8.dp),
                ) {
                    Icon(
                        painterResource(Res.drawable.warning_icon),
                        null,
                        tint = Color.Red,
                        modifier =
                        Modifier
                            .size(28.dp)
                    )
                }

                Column {
                    Text(
                        text = Alerter.title.value,
                        overflow = TextOverflow.Ellipsis,
                        style =
                        MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.Bold,
                        ),
                        color = Color.White,
                    )

                    Text(
                        text = Alerter.message.value,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White,
                    )
                }
            }

        }

    }



    Alerter(
        isVisible = isVisibleSuccess.value, alertStyle = AlertStyle.Standard,
        onChanged = { isVisibleSuccess.value = it }, enableDismissWhenAlertClick = false,
        backgroundColor = Color.Green
    ) {
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Row(
                modifier =
                Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .clip(RoundedCornerShape(16.dp))
                    .padding(horizontal = 16.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier =
                    Modifier
                        .size(38.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .padding(8.dp),
                ) {
                    Icon(
                        painterResource(Res.drawable.ic_success),
                        null,
                        tint = Color.Green,
                        modifier =
                        Modifier
                            .size(28.dp)
                    )
                }

                Column {
                    Text(
                        text = Alerter.title.value,
                        overflow = TextOverflow.Ellipsis,
                        style =
                        MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.Bold,
                        ),
                        color = Color.White,
                    )

                    Text(
                        text = Alerter.message.value,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White,
                    )
                }
            }

        }

    }
}

