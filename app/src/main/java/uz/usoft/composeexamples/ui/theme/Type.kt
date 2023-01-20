package uz.usoft.composeexamples.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val hDefault = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Bold,
)

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = hDefault.copy(
        fontSize = 28.sp,
        lineHeight = 36.sp,
    ),
    h2 = hDefault.copy(
        fontSize = 20.sp,
        lineHeight = 38.sp,
    ),
    h3 = hDefault.copy(
        fontSize = 18.sp,
        lineHeight = 24.sp
    ),
    h4 =  hDefault.copy(
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 20.sp
    ),
//    body1 = TextStyle(
//        fontFamily = FontFamily.Default,
//        fontWeight = FontWeight.Normal,
//        fontSize = 16.sp
//    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)