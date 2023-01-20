package uz.usoft.composeexamples.ui.theme

import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import uz.usoft.composeexamples.ui.theme.typography.*
import uz.usoft.composeexamples.ui.theme.typography.LocalZorGoBody
import uz.usoft.composeexamples.ui.theme.typography.LocalZorGoHeadlines

object ZorGoTypography {
    val headlines: ZorGoHeadlines
        @Composable
        @ReadOnlyComposable
        get() = LocalZorGoHeadlines.current

    val body: ZorGoBody
        @Composable
        @ReadOnlyComposable
        get() = LocalZorGoBody.current

    val buttonLink: ZorGoButtonLink
        @Composable
        @ReadOnlyComposable
        get() = LocalZorGoButtonLink.current

    val field: ZorGoField
        @Composable
        @ReadOnlyComposable
        get() = LocalZorGoField.current
}

@Composable
fun ZorGoTypography(
    headlines: ZorGoHeadlines = ZorGoTypography.headlines,
    body: ZorGoBody = ZorGoTypography.body,
    buttonLink: ZorGoButtonLink = ZorGoTypography.buttonLink,
    field: ZorGoField = ZorGoTypography.field,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalZorGoHeadlines provides headlines,
        LocalZorGoBody provides body,
        LocalZorGoButtonLink provides buttonLink,
        LocalZorGoField provides field,
        content = content
    )
}