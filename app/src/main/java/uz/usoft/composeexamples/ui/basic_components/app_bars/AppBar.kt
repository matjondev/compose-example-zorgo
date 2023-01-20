package uz.usoft.composeexamples.ui.basic_components.app_bars

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.usoft.composeexamples.ui.theme.ComposeExamplesTheme
import uz.usoft.composeexamples.ui.theme.ZorGoTypography
import uz.usoft.composeexamples.R


@Composable
fun BasicTopAppBar(
    name: String,
    modifier: Modifier = Modifier,
    onBackClicked: (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {}
) {
    val navigationIcon: @Composable (() -> Unit)? = onBackClicked?.let {
        @Composable {
            IconButton(onClick = onBackClicked) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_left),
                    contentDescription = "nav back"
                )
            }
        }
    }

    TopAppBar(
        backgroundColor = Color.Transparent,
        contentColor = LocalContentColor.current,
        modifier = modifier,
        elevation = 0.dp,
        title = {
            Text(text = name, style = ZorGoTypography.headlines.h3)
        },
        navigationIcon = navigationIcon,
        actions = actions,
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewBasicTopBar() {
    ComposeExamplesTheme() {
        ZorGoTypography() {
            BasicTopAppBar(name = "Test", onBackClicked = {})
        }
    }
}