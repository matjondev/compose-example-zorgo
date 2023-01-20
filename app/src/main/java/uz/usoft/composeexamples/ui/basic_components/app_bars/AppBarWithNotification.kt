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
fun AppBarWithNotificationAction(
    name: String,
    modifier: Modifier = Modifier,
    notificationCount: Int = 0,
    onBackClicked: (() -> Unit)? = null,
    onNotificationClicked: () -> Unit = {}
) {
    BasicTopAppBar(
        name = name,
        modifier = modifier,
        onBackClicked = onBackClicked,
        actions = {
            Box() {
                IconButton(onClick = onNotificationClicked) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_bell),
                        contentDescription = ""
                    )
                }
                if (notificationCount != 0) {
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .align(Alignment.TopEnd)
                            .requiredSize(16.dp)
                            .background(MaterialTheme.colors.error, CircleShape)
                    ) {
                        Text(
                            text = notificationCount.toString(),
                            style = ZorGoTypography.body.body4,
                            color = MaterialTheme.colors.onError,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }

            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewAppBarWithNotificationAction() {
    ComposeExamplesTheme() {
        ZorGoTypography() {
            AppBarWithNotificationAction(
                name = "Test",
                onBackClicked = {},
                notificationCount = 4,
                onNotificationClicked = {}
            )
        }
    }
}