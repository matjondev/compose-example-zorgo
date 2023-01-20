package uz.usoft.composeexamples.ui.basic_components.buttons

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import uz.usoft.composeexamples.R
import uz.usoft.composeexamples.ui.theme.*

@Composable
fun SecondaryIconButton(
    iconPainter: Painter,
    modifier: Modifier = Modifier,
    iconSize: Dp = 24.dp,
    contentPadding: PaddingValues = PaddingValues(horizontal = 32.dp, vertical = 16.dp),
    isLoading: Boolean = false,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    StandardIconButton(
        iconPainter = iconPainter,
        modifier = modifier,
        iconSize = iconSize,
        contentPadding = contentPadding,
        iconTint = Gray700,
        backgroundColor = Gray50,
        hoveredBackgroundColor = Gray200,
        focusedBackgroundColor = Gray200,
        pressedBackgroundColor = Gray300,
        loadingBackgroundColor = Gray300,
        borderStroke = BorderStroke(1.dp, Gray500),
        isLoading = isLoading,
        enabled = enabled,
        onClick = onClick
    )
}

@Composable
fun SecondaryIconButton(
    iconPainter: Painter,
    modifier: Modifier = Modifier,
    buttonSizeType: ButtonSizeType = ButtonSizeType.Large,
    isLoading: Boolean = false,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    SecondaryIconButton(
        iconPainter = iconPainter,
        modifier = modifier.size(buttonSizeType.size),
        iconSize = buttonSizeType.iconSize,
        contentPadding = buttonSizeType.iconPadding,
        isLoading = isLoading,
        enabled = enabled,
        onClick = onClick
    )
}


@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun PreviewSecondaryIconButton() {
    ComposeExamplesTheme() {
        ZorGoTypography() {
                SecondaryIconButton(
                    iconPainter = painterResource(id = R.drawable.plus),
                    buttonSizeType = ButtonSizeType.Large
                ) {

                }

        }
    }
}