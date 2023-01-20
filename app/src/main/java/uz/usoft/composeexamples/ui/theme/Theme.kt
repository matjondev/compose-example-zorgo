package uz.usoft.composeexamples.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

private val colorPalette = lightColors(
    primary = Blue800,
    primaryVariant = Blue700,
    secondary = Gray50,
    secondaryVariant = Gray50,
    background = Blue100,
    surface = Color.White,
    error = Red700,
    onPrimary = Color.White,
    onSecondary = Gray900,
    onBackground = Gray900,
    onSurface = Gray900,
    onError = Color.White,
)

@Composable
fun ComposeExamplesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    MaterialTheme(
        colors = colorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

fun Color.toDisabled(): Color = this.copy(alpha = 0.4f)