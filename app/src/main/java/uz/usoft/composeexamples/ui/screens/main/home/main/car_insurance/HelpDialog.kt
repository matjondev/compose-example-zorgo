package uz.usoft.composeexamples.ui.screens.main.home.main.car_insurance

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import uz.usoft.composeexamples.R
import uz.usoft.composeexamples.ui.basic_components.buttons.ButtonSizeType
import uz.usoft.composeexamples.ui.basic_components.buttons.LinkButton
import uz.usoft.composeexamples.ui.basic_components.buttons.SecondaryButton
import uz.usoft.composeexamples.ui.theme.ZorGoTypography

@Composable
fun HelpDialog(onDismissRequest: () -> Unit) {
    Dialog(
        onDismissRequest = onDismissRequest,
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(28.dp),
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = stringResource(R.string.help_dialog_content),
                    style = ZorGoTypography.body.body2,
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    LinkButton(
                        text = stringResource(R.string.more),
                        buttonSizeType = ButtonSizeType.Small,
                        onClick = {}
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    SecondaryButton(
                        text = stringResource(R.string.close),
                        buttonSizeType = ButtonSizeType.Medium,
                        onClick = { onDismissRequest() })
                }
            }
        }

    }
}