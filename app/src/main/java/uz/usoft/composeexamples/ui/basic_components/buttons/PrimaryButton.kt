package uz.usoft.composeexamples.ui.basic_components.buttons

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import uz.usoft.composeexamples.ui.theme.*

@Composable
fun PrimaryButton(
    text: String,
    modifier: Modifier = Modifier,
    iconSize: Dp = 24.dp,
    textStyle: TextStyle = ZorGoTypography.buttonLink.normal,
    contentPadding: PaddingValues = PaddingValues(horizontal = 32.dp, vertical = 16.dp),
    borderStroke: BorderStroke? = null,
    startPainter: Painter? = null,
    endPainter: Painter? = null,
    isLoading: Boolean = false,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    StandardButton(
        text = text,
        modifier = modifier,
        iconSize = iconSize,
        textStyle = textStyle,
        contentPadding = contentPadding,
        backgroundColor = Blue800,
        hoveredBackgroundColor = Blue700,
        focusedBackgroundColor = Blue700,
        pressedBackgroundColor = Blue900,
        loadingBackgroundColor = Blue900,
        textColor = Color.White,
        iconTint = Color.White,
        borderStroke = borderStroke,
        startPainter = startPainter,
        endPainter = endPainter,
        isLoading = isLoading,
        enabled = enabled,
        onClick = onClick
    )
}

@Composable
fun PrimaryButton(
    text: String,
    modifier: Modifier = Modifier,
    buttonSizeType: ButtonSizeType = ButtonSizeType.Large,
    borderStroke: BorderStroke? = null,
    startPainter: Painter? = null,
    endPainter: Painter? = null,
    isLoading: Boolean = false,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    val textStyle = when (buttonSizeType) {
        ButtonSizeType.Large -> ZorGoTypography.buttonLink.normal
        ButtonSizeType.Medium -> ZorGoTypography.buttonLink.medium
        ButtonSizeType.Small -> ZorGoTypography.buttonLink.small
    }
    PrimaryButton(
        text = text,
        modifier = modifier.height(buttonSizeType.size),
        iconSize = buttonSizeType.iconSize,
        textStyle = textStyle,
        contentPadding = buttonSizeType.contentPadding,
        borderStroke = borderStroke,
        startPainter = startPainter,
        endPainter = endPainter,
        isLoading = isLoading,
        enabled = enabled,
        onClick = onClick,
    )
}



@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun PreviewPrimaryButton() {
    ComposeExamplesTheme() {
        ZorGoTypography() {
            PrimaryButton(
                text = "Label",
                buttonSizeType = ButtonSizeType.Small
            ) {

            }
        }
    }
}

