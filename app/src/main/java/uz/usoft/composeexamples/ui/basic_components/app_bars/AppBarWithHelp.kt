package uz.usoft.composeexamples.ui.basic_components.app_bars

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.usoft.composeexamples.R
import uz.usoft.composeexamples.ui.theme.ComposeExamplesTheme
import uz.usoft.composeexamples.ui.theme.ZorGoTypography

@Composable
fun AppBarWithHelpAction(
    name: String,
    modifier: Modifier = Modifier,
    onBackClicked: (() -> Unit)? = null,
    onHelpClicked: () -> Unit
) {
    BasicTopAppBar(
        name = name,
        modifier = modifier,
        onBackClicked = onBackClicked,
        actions = {
            IconButton(onClick = onHelpClicked) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_help_circle),
                    contentDescription = ""
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewAppBarWithHelpAction() {
    ComposeExamplesTheme() {
        ZorGoTypography() {
            AppBarWithHelpAction(
                name = "Test",
                onBackClicked = {},
                onHelpClicked = {}
            )
        }
    }
}