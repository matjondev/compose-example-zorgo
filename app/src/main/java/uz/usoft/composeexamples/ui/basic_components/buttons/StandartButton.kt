package uz.usoft.composeexamples.ui.basic_components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import uz.usoft.composeexamples.ui.theme.Gray900
import uz.usoft.composeexamples.ui.theme.ZorGoTypography

enum class ButtonSizeType(
    val size: Dp,
    val iconSize: Dp,
    val contentPadding: PaddingValues,
    val iconPadding: PaddingValues,
) {
    Large(
        56.dp,
        24.dp,
        PaddingValues(horizontal = 32.dp, vertical = 16.dp),
        PaddingValues(horizontal = 16.dp, vertical = 16.dp)
    ),
    Medium(
        48.dp,
        20.dp,
        PaddingValues(horizontal = 32.dp, vertical = 14.dp),
        PaddingValues(horizontal = 14.dp, vertical = 14.dp)
    ),
    Small(
        32.dp,
        16.dp,
        PaddingValues(horizontal = 24.dp, vertical = 8.dp),
        PaddingValues(horizontal = 8.dp, vertical = 8.dp)
    ),
}

@Composable
fun StandardButton(
    text: String,
    modifier: Modifier = Modifier,
    iconSize: Dp = 24.dp,
    textStyle: TextStyle = ZorGoTypography.buttonLink.normal,
    contentPadding: PaddingValues = PaddingValues(horizontal = 32.dp, vertical = 16.dp),
    backgroundColor: Color = MaterialTheme.colors.primary,
    hoveredBackgroundColor: Color = MaterialTheme.colors.primary,
    focusedBackgroundColor: Color = MaterialTheme.colors.primary,
    pressedBackgroundColor: Color = MaterialTheme.colors.primary,
    loadingBackgroundColor: Color = MaterialTheme.colors.primary,
    textColor: Color = MaterialTheme.colors.onPrimary,
    iconTint: Color = MaterialTheme.colors.onPrimary,
    borderStroke: BorderStroke? = null,
    focusedStroke: BorderStroke? = BorderStroke(2.dp, Gray900),
    startPainter: Painter? = null,
    endPainter: Painter? = null,
    isLoading: Boolean = false,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    val interactions = remember { MutableInteractionSource() }
    val isPressed by interactions.collectIsPressedAsState()
    val isFocused by interactions.collectIsFocusedAsState()
    val isHovered by interactions.collectIsHoveredAsState()
    val background = when {
        isLoading -> loadingBackgroundColor
        isPressed -> pressedBackgroundColor
        isFocused -> focusedBackgroundColor
        isHovered -> hoveredBackgroundColor
        else -> backgroundColor
    }

    val currentBorderStroke =
        if (isFocused && !isLoading && !isHovered && !isPressed) focusedStroke
        else borderStroke

    Button(
        onClick = onClick,
        shape = CircleShape,
        modifier = Modifier.then(modifier),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = background,
            disabledBackgroundColor = backgroundColor.copy(alpha = 0.4f),
            disabledContentColor = textColor.copy(alpha = 0.4f)
        ),
        border = currentBorderStroke,
        elevation = ButtonDefaults.elevation(),
        enabled = enabled,
        contentPadding = contentPadding,
        interactionSource = interactions
    ) {

        if (startPainter != null) {
            Image(
                painter = startPainter,
                contentDescription = "",
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(iconSize),
                colorFilter = ColorFilter.tint(iconTint)
            )
        }

        Text(
            text = text,
            color = textColor,
            style = textStyle,
            maxLines = 1,
            modifier = Modifier.align(Alignment.CenterVertically)
        )

        if (isLoading && enabled) {
            CircularProgressIndicator(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .size(iconSize),
                color = iconTint,
                strokeWidth = 2.dp
            )
        } else {
            if (endPainter != null) {
                Image(
                    painter = endPainter,
                    contentDescription = "",
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .size(iconSize),
                    colorFilter = ColorFilter.tint(iconTint)
                )
            }
        }
    }
}
