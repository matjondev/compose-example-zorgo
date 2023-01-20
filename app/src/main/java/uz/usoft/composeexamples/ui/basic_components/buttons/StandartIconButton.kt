package uz.usoft.composeexamples.ui.basic_components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import uz.usoft.composeexamples.ui.theme.Gray900

@Composable
fun StandardIconButton(
    iconPainter: Painter,
    modifier: Modifier = Modifier,
    iconSize: Dp = 24.dp,
    iconTint: Color = MaterialTheme.colors.onPrimary,
    backgroundColor: Color = MaterialTheme.colors.primary,
    hoveredBackgroundColor: Color = MaterialTheme.colors.primary,
    focusedBackgroundColor: Color = MaterialTheme.colors.primary,
    pressedBackgroundColor: Color = MaterialTheme.colors.primary,
    loadingBackgroundColor: Color = MaterialTheme.colors.primary,
    contentPadding: PaddingValues = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
    borderStroke: BorderStroke? ,
    focusedStroke: BorderStroke? = BorderStroke(2.dp, Gray900),
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

    val strokeModifier = Modifier

    currentBorderStroke?.let { strokeModifier.border(it) }
    
    IconButton(
        modifier = Modifier
            .clip(CircleShape)
            .then(strokeModifier)
            .background(backgroundColor)
            .then(modifier),
        enabled = enabled,
        interactionSource = interactions,
        onClick = { /*TODO*/ }
    ) {
        if (isLoading && enabled) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(iconSize),
                color = iconTint,
                strokeWidth = 2.dp
            )
        } else {
            Image(
                painter = iconPainter,
                contentDescription = "",
                modifier = Modifier
                    .size(iconSize),
                colorFilter = ColorFilter.tint(iconTint)
            )
        }
    }

//    Button(
//        onClick = onClick,
//        shape = CircleShape,
//        modifier = Modifier
//            .requiredWidthIn(min = 0.dp)
//            .then(modifier),
//        colors = ButtonDefaults.buttonColors(
//            backgroundColor = background,
//            disabledBackgroundColor = backgroundColor.copy(alpha = 0.4f),
//            disabledContentColor = iconTint.copy(alpha = 0.4f)
//        ),
//        border = currentBorderStroke,
//        elevation = ButtonDefaults.elevation(),
//        enabled = enabled,
//        contentPadding = contentPadding
//    ) {
//        if (isLoading && enabled) {
//            CircularProgressIndicator(
//                modifier = Modifier
//                    .size(iconSize),
//                color = iconTint,
//                strokeWidth = 2.dp
//            )
//        } else {
//            Image(
//                painter = iconPainter,
//                contentDescription = "",
//                modifier = Modifier
//                    .size(iconSize),
//                colorFilter = ColorFilter.tint(iconTint)
//            )
//        }
//    }
}