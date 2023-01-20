package uz.usoft.composeexamples.ui.basic_components.radio_button

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import uz.usoft.composeexamples.ui.theme.*

@Composable
fun ZorGoRadioButton(
    selected: Boolean,
    onClick: (() -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {

    val colors: RadioButtonColors = RadioButtonDefaults.colors(
        selectedColor = MaterialTheme.colors.primary,
        unselectedColor = Gray500,
        disabledColor = Blue50,
    )

    RadioButton(
        selected = selected,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        interactionSource = interactionSource,
        colors = colors,
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewZorGoRadioButton() {
    ComposeExamplesTheme() {
        ZorGoTypography() {
            Surface() {
                var isSelected by remember { mutableStateOf(false) }
                ZorGoRadioButton(selected = isSelected, onClick = { isSelected = !isSelected })
            }
        }
    }
}
