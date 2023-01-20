package uz.usoft.composeexamples.ui.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import uz.usoft.composeexamples.R
import uz.usoft.composeexamples.ui.theme.Blue100
import uz.usoft.composeexamples.ui.theme.Blue200
import uz.usoft.composeexamples.ui.theme.Blue700
import uz.usoft.composeexamples.ui.theme.GradientMain


@Composable
fun BoxWithMainBackground(
    content: @Composable BoxWithConstraintsScope.() -> Unit
) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .systemBarsPadding()
    ) {
        Spacer(
            modifier = Modifier
                .offset(minWidth / 2, -minWidth / 5)
                .size(minWidth)
                .clip(CircleShape)
                .background(Blue200)
        )
        Spacer(
            modifier = Modifier
                .offset(-minWidth / 2, minWidth + 12.dp - minWidth / 5)
                .size(minWidth)
                .clip(CircleShape)
                .background(Blue200)
        )

        CompositionLocalProvider(LocalContentColor provides MaterialTheme.colors.onBackground) {
            content()
        }
    }
}