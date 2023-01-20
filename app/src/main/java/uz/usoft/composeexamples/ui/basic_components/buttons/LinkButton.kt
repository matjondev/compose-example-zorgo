package uz.usoft.composeexamples.ui.basic_components.buttons

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import uz.usoft.composeexamples.ui.theme.ComposeExamplesTheme
import uz.usoft.composeexamples.ui.theme.Gray900
import uz.usoft.composeexamples.ui.theme.ZorGoTypography

@Composable
fun LinkButton(
    text: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = ZorGoTypography.buttonLink.normal,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    val interactions = remember { MutableInteractionSource() }
    val isPressed by interactions.collectIsPressedAsState()
    val isFocused by interactions.collectIsFocusedAsState()
    val isHovered by interactions.collectIsHoveredAsState()
    val currentBorderStroke =
        if (isFocused && !isHovered && !isPressed) BorderStroke(2.dp, Gray900)
        else null

    val isUnderLine = isHovered || isPressed
    val textDecoration = if (isUnderLine) TextDecoration.Underline else TextDecoration.None

    Button(
        onClick = onClick,
        modifier = Modifier.then(modifier),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent,
            disabledBackgroundColor = Color.Transparent,
            disabledContentColor = MaterialTheme.colors.primary.copy(alpha = 0.4f)
        ),
        border = currentBorderStroke,
        elevation = ButtonDefaults.elevation(0.dp, 0.dp, 0.dp, 0.dp, 0.dp),
        enabled = enabled,
        interactionSource = interactions
    ) {
        Text(
            text = text,
            color = MaterialTheme.colors.primary,
            style = textStyle,
            maxLines = 1,
            textDecoration = textDecoration
        )
    }
}

@Composable
fun LinkButton(
    text: String,
    modifier: Modifier = Modifier,
    buttonSizeType: ButtonSizeType = ButtonSizeType.Large,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    val textStyle = when (buttonSizeType) {
        ButtonSizeType.Large -> ZorGoTypography.buttonLink.normal
        ButtonSizeType.Medium -> ZorGoTypography.buttonLink.medium
        ButtonSizeType.Small -> ZorGoTypography.buttonLink.small
    }
    LinkButton(
        text = text,
        modifier = modifier,
        textStyle = textStyle,
        enabled = enabled,
        onClick = onClick
    )
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun PreviewLinkButton() {
    ComposeExamplesTheme() {
        ZorGoTypography() {
            LinkButton(
                text = "Label",
                buttonSizeType = ButtonSizeType.Large
            ) {

            }
        }
    }
}

