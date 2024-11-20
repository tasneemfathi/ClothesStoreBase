package com.stores.clothes.ui.theme


import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import clothesappdemo.composeapp.generated.resources.Res
import clothesappdemo.composeapp.generated.resources.black
import clothesappdemo.composeapp.generated.resources.bold
import clothesappdemo.composeapp.generated.resources.light
import clothesappdemo.composeapp.generated.resources.regular
import clothesappdemo.composeapp.generated.resources.semibold
import org.jetbrains.compose.resources.Font

val MyAppFontFamily : FontFamily
    @Composable
    get() = FontFamily(
    Font(Res.font.light, weight = FontWeight.Light),
    Font(Res.font.regular, weight = FontWeight.Normal),
    Font(Res.font.black, weight = FontWeight.Black),
    Font(Res.font.bold, weight = FontWeight.Bold),
    Font(Res.font.semibold, weight = FontWeight.SemiBold),
)

val title :TextStyle
    @Composable
    get()= TextStyle(
    fontFamily = MyAppFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 20.sp,
    color = TextColor
)
val subtitle :TextStyle
    @Composable
    get()= TextStyle(
    fontFamily = MyAppFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 16.sp,
     color = TextColor,
)


val bodyMedium :TextStyle
    @Composable
    get() = TextStyle(
    fontFamily = MyAppFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp,
    color = TextColor,
    lineHeight = 20.sp
    )

val body :TextStyle
@Composable
    get() = TextStyle(
    fontFamily = MyAppFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp,
    color = TextColor,
    lineHeight = 20.sp
    )

val bodyBold :TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = MyAppFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        color = TextColor,
        lineHeight = 20.sp
    )
val buttons :TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = MyAppFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        color = Color.White
    )


val typography  :Typography
    @Composable
    get() = Typography(
    titleLarge = title,
    headlineLarge = subtitle,
    bodyMedium = bodyMedium,
    bodySmall = body
)

