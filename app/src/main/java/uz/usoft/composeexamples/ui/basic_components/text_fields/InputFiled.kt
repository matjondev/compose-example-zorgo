package uz.usoft.composeexamples.ui.basic_components.text_fields

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.usoft.composeexamples.ui.theme.*
import uz.usoft.composeexamples.R

private val InputDefaultHeight = 56.dp
private val CornerRadius = InputDefaultHeight / 2
private val FocusedStrokeWidth = 4.dp
private val UnFocusedStrokeWidth = 0.dp
private val MessageHeight = 16.dp

private val textStyle @Composable get() = ZorGoTypography.field.text1

    private val DefaultStrokeColor = Color.Transparent
private val WarningStrokeColor @Composable get() = Yellow700
private val ErrorStrokeColor @Composable get() = MaterialTheme.colors.error
private val FocusedStrokeColor @Composable get() = MaterialTheme.colors.primary

private val DefaultBackgroundColor @Composable get() = MaterialTheme.colors.surface
private val LoadingBackgroundColor @Composable get() = Blue50
private val FocusedBackgroundColor @Composable get() = Blue50
private val WarningBackgroundColor @Composable get() = Yellow50
private val ErrorBackgroundColor @Composable get() = Red50
private val DisabledBackgroundColor @Composable get() = DefaultBackgroundColor.toDisabled()

private val DefaultIconTint @Composable get() = Gray700
private val FocusedIconTint @Composable get() = MaterialTheme.colors.primary

@Composable
fun ZorGoTextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier,
    inputFiledState: InputFiledState = InputFiledState.Idle,
    readOnly: Boolean = false,
    contentMessage: @Composable (() -> Unit)? = null,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),
    singleLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val isFocused by interactionSource.collectIsFocusedAsState()
    val isHovered by interactionSource.collectIsHoveredAsState()
    val enabled: Boolean = inputFiledState !is InputFiledState.Disabled
    val isError: Boolean = inputFiledState is InputFiledState.Error

    val borderWidth = when (inputFiledState) {
        is InputFiledState.Loading -> UnFocusedStrokeWidth
        is InputFiledState.Warning -> FocusedStrokeWidth
        is InputFiledState.Error -> FocusedStrokeWidth
        is InputFiledState.Disabled -> UnFocusedStrokeWidth
        is InputFiledState.Success, InputFiledState.Idle -> if (isFocused || isHovered) FocusedStrokeWidth else UnFocusedStrokeWidth
    }
    val strokeColor = when (inputFiledState) {
        is InputFiledState.Loading -> DefaultStrokeColor
        is InputFiledState.Warning -> WarningStrokeColor
        is InputFiledState.Error -> ErrorStrokeColor
        is InputFiledState.Disabled -> DefaultStrokeColor
        is InputFiledState.Success, is InputFiledState.Idle ->
            if (isFocused || isHovered) FocusedStrokeColor else DefaultStrokeColor
    }
    val background = when (inputFiledState) {
        is InputFiledState.Loading -> LoadingBackgroundColor
        is InputFiledState.Warning -> WarningBackgroundColor
        is InputFiledState.Error -> ErrorBackgroundColor
        is InputFiledState.Disabled -> DisabledBackgroundColor
        is InputFiledState.Success, is InputFiledState.Idle -> if (isHovered) FocusedBackgroundColor else DefaultBackgroundColor
    }

    val iconTint = when (inputFiledState) {
        is InputFiledState.Idle -> if (isFocused || isHovered) FocusedIconTint else DefaultIconTint
        else -> DefaultIconTint
    }
    val borderStroke = BorderStroke(borderWidth, strokeColor)
    val shape: Shape = RoundedCornerShape(CornerRadius)


    val colors: TextFieldColors = TextFieldDefaults.textFieldColors(
        textColor = MaterialTheme.colors.onSurface,
        disabledTextColor = MaterialTheme.colors.onSurface.toDisabled(),
        backgroundColor = background,
        cursorColor = MaterialTheme.colors.primary,
        errorCursorColor = MaterialTheme.colors.error,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent,
        errorIndicatorColor = Color.Transparent,
        leadingIconColor = iconTint,
        disabledLeadingIconColor = Gray700.toDisabled(),
        errorLeadingIconColor = Gray700,
        trailingIconColor = iconTint,
        disabledTrailingIconColor = Gray700.toDisabled(),
        errorTrailingIconColor = Gray700,
        focusedLabelColor = Gray700,
        unfocusedLabelColor = Gray700,
        disabledLabelColor = Gray700.toDisabled(),
        errorLabelColor = Gray700,
        placeholderColor = Gray700,
        disabledPlaceholderColor = Gray700.toDisabled(),
    )

    val isContainAnyMessage by remember {
        mutableStateOf(
            inputFiledState is InputFiledState.Loading ||
                    inputFiledState is InputFiledState.Warning ||
                    inputFiledState is InputFiledState.Error ||
                    inputFiledState is InputFiledState.Success ||
                    contentMessage != null
        )
    }

    Column(modifier = Modifier.then(modifier)) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .sizeIn(minHeight = InputDefaultHeight)
                .border(borderStroke, shape)
                .padding(horizontal = 4.dp),
            enabled = enabled,
            readOnly = readOnly,
            textStyle = textStyle,
            label = label,
            placeholder = placeholder,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            isError = isError,
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            singleLine = singleLine,
            maxLines = maxLines,
            interactionSource = interactionSource,
            shape = shape,
            colors = colors,
        )

        AnimatedVisibility(visible = isContainAnyMessage) {
            Spacer(modifier = Modifier.height(8.dp))
            Row() {
                when (inputFiledState) {
                    is InputFiledState.Loading -> {
                        FieldLoadingMessage(message = inputFiledState.message)
                    }
                    is InputFiledState.Warning -> {
                        FieldWarningMessage(message = inputFiledState.message)
                    }
                    is InputFiledState.Error -> {
                        FieldErrorMessage(message = inputFiledState.message)
                    }
                    is InputFiledState.Success -> {
                        FieldSuccessMessage(message = inputFiledState.message)
                    }
                    else -> {}
                }
                Spacer(modifier = Modifier.weight(1f))
                CompositionLocalProvider(LocalContentColor provides Gray600) {
                    contentMessage?.invoke()
                }
            }
        }
    }

}

@Composable
private fun FieldLoadingMessage(message: String) {
    CompositionLocalProvider(LocalContentColor provides Gray600) {
        Row(modifier = Modifier.height(MessageHeight)) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(16.dp),
                color = LocalContentColor.current,
                strokeWidth = 1.2.dp
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = message, style = ZorGoTypography.field.text2)
        }
    }
}

@Composable
private fun FieldWarningMessage(message: String) {
    CompositionLocalProvider(LocalContentColor provides Yellow700) {
        Row(modifier = Modifier.height(MessageHeight)) {
            Icon(
                painter = painterResource(id = R.drawable.ic_alert_triangle),
                contentDescription = "",
                tint = LocalContentColor.current
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = message, style = ZorGoTypography.field.text2)
        }
    }
}

@Composable
private fun FieldErrorMessage(message: String) {
    CompositionLocalProvider(LocalContentColor provides Red700) {
        Row(modifier = Modifier.height(MessageHeight)) {
            Icon(
                painter = painterResource(id = R.drawable.ic_x),
                contentDescription = "",
                tint = LocalContentColor.current
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = message, style = ZorGoTypography.field.text2)
        }
    }
}

@Composable
private fun FieldSuccessMessage(message: String) {
    CompositionLocalProvider(LocalContentColor provides Green700) {
        Row(modifier = Modifier.height(MessageHeight)) {
            Icon(
                painter = painterResource(id = R.drawable.ic_check),
                contentDescription = "",
                tint = LocalContentColor.current
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = message, style = ZorGoTypography.field.text2)
        }
    }
}

sealed interface InputFiledState {
    object Idle : InputFiledState
    data class Loading(val message: String = "loading") : InputFiledState
    data class Warning(val message: String = "warning") : InputFiledState
    data class Error(val message: String = "error") : InputFiledState
    data class Success(val message: String = "success") : InputFiledState
    object Disabled : InputFiledState
}

@Preview(showBackground = true)
@Composable
fun PreviewInputField() {
    ComposeExamplesTheme() {
        ZorGoTypography() {
            var text by remember { mutableStateOf(TextFieldValue("")) }
            ZorGoTextField(
                value = text,
                onValueChange = { text = it },
                inputFiledState = InputFiledState.Idle,
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = "Label")
                },
                placeholder = {
                    Text(text = "PlaceHolder")
                },
                contentMessage = {
                    Text(text = "0/200")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "")
                },
                trailingIcon = {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "")
                },
            )
        }
    }
}