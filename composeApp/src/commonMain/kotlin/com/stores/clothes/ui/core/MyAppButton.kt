package com.stores.clothes.ui.core

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.stores.clothes.ui.theme.HintColor
import com.stores.clothes.ui.theme.Primary
import com.stores.clothes.ui.theme.buttons
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource


@Composable
fun MyAppButton( modifier: Modifier = Modifier,
                 onClick: () -> Unit,
                 title: String,
                 iconStart: DrawableResource? = null,
                 iconEnd: DrawableResource? = null,
                 isEnabled: Boolean = true,
                 isLoading: Boolean = false){

    Button(onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp),
        enabled = isEnabled && isLoading.not(),
        shape = RoundedCornerShape(14.dp),
        colors = ButtonColors(contentColor = Color.White, containerColor = Primary, disabledContentColor = Color.White, disabledContainerColor = Primary.copy(alpha = 0.7f)),
        elevation = ButtonDefaults.buttonElevation(5.dp),
        border = null,
        contentPadding = ButtonDefaults.ContentPadding,
    ) {
        if(isLoading.not()){
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                if (iconStart != null) {
                    Icon(
                        painter = painterResource(resource = iconStart),
                        tint = Color.White,
                        contentDescription = ""
                    )
                }
                ResizableText(
                    text = title,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    maxLines = 1,
                    minLines = 1,
                    fontSizeRange = 6..14,
                    style = buttons
                )
                if (iconEnd != null) {
                    Icon(
                        painter = painterResource(resource = iconEnd),
                        tint = Color.White,
                        contentDescription = ""
                    )
                }

            }
        }else{
            CircularProgressIndicator(color = Color.White)

        }
    }
}
