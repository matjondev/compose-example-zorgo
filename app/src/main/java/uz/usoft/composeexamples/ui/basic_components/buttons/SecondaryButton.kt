package uz.usoft.composeexamples.ui.basic_components.buttons

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import uz.usoft.composeexamples.ui.theme.*

@Composable
fun SecondaryButton(
    text: String,
    modifier: Modifier = Modifier,
    iconSize: Dp = 24.dp,
    textStyle: TextStyle = ZorGoTypography.buttonLink.normal,
    contentPadding: PaddingValues = PaddingValues(horizontal = 32.dp, vertical = 16.dp),
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
        backgroundColor = Gray50,
        hoveredBackgroundColor = Gray200,
        focusedBackgroundColor = Gray200,
        pressedBackgroundColor = Gray300,
        loadingBackgroundColor = Gray300,
        textColor = Gray900,
        iconTint = Gray700,
        borderStroke = BorderStroke(1.dp, Gray500),
        startPainter = startPainter,
        endPainter = endPainter,
        isLoading = isLoading,
        enabled = enabled,
        onClick = onClick
    )
}

@Composable
fun SecondaryButton(
    text: String,
    modifier: Modifier = Modifier,
    buttonSizeType: ButtonSizeType = ButtonSizeType.Large,
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
    SecondaryButton(
        text = text,
        modifier = modifier.height(buttonSizeType.size),
        iconSize = buttonSizeType.iconSize,
        textStyle = textStyle,
        contentPadding = buttonSizeType.contentPadding,
        startPainter = startPainter,
        endPainter = endPainter,
        isLoading = isLoading,
        enabled = enabled,
        onClick = onClick,
    )
}


@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun PreviewSecondaryButton() {
    ComposeExamplesTheme() {
        ZorGoTypography() {
            SecondaryButton(
                text = "Label",
                buttonSizeType = ButtonSizeType.Small
            ) {

            }
        }
    }
}

