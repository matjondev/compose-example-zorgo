package uz.usoft.composeexamples.ui.screens.auth

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import uz.usoft.composeexamples.ui.navigation.Screen
import uz.usoft.composeexamples.ui.theme.Blue700
import uz.usoft.composeexamples.ui.theme.GradientMain
import uz.usoft.composeexamples.R
import uz.usoft.composeexamples.ui.basic_components.buttons.ButtonSizeType
import uz.usoft.composeexamples.ui.basic_components.buttons.PrimaryButton
import uz.usoft.composeexamples.ui.theme.ZorGoTypography

@Composable
fun LaunchScreen(navController: NavController) {

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(GradientMain)
    ) {
        Spacer(
            modifier = Modifier
                .offset(minWidth / 2, -minWidth / 5)
                .size(minWidth)
                .clip(CircleShape)
                .background(Blue700)
        )
        Spacer(
            modifier = Modifier
                .offset(-minWidth / 2, minWidth + 12.dp - minWidth / 5)
                .size(minWidth)
                .clip(CircleShape)
                .background(Blue700)
        )
        Image(
            painter = painterResource(id = R.drawable.ic_illustration),
            contentDescription = "Illustration",
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .size(width = minWidth, height = minHeight / 2)
                .offset(y = minWidth / 3 - 12.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.rocket_new),
            contentDescription = "rocket_new",
            modifier = Modifier
                .size(minWidth)
                .align(Alignment.BottomCenter)
        )

        CompositionLocalProvider(
            LocalContentColor provides MaterialTheme.colors.onPrimary
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
                    .systemBarsPadding()

            ) {
                ChangeLanguageButton(
                    currentLanguage = "Рус",
                    modifier = Modifier.align(Alignment.End),
                    onClick = {})
                Image(
                    painter = painterResource(id = R.drawable.skeuo_logo),
                    contentDescription = "skeuo_logo",
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 24.dp)
                        .size(200.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.name_logo),
                    contentDescription = "name_logo",
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .width(200.dp)
                        .offset(y = (-32).dp)
                )

                Text(
                    text = "МОМЕНТАЛЬНОЕ\n СТРАХОВАНИЕ",
                    style = TextStyle(
                        color = LocalContentColor.current,
                        fontSize = 20.sp,
                        lineHeight = 28.sp,
                        fontWeight = FontWeight.Medium
                    ),
                    color = LocalContentColor.current,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.weight(1f))

                PrimaryButton(
                    text = stringResource(R.string.start),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 48.dp)
                        .padding(bottom = 16.dp),
                    buttonSizeType = ButtonSizeType.Large,
                    borderStroke = BorderStroke(2.dp, MaterialTheme.colors.onPrimary),
                    onClick = {
                        navController.navigate(Screen.Auth.AuthEnterPhone.screenName) {
                            popUpTo(Screen.Auth.Launch.screenName) { inclusive = true }
                        }
                    }
                )
            }
        }

    }
}

@Composable
private fun ChangeLanguageButton(
    currentLanguage: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Row(modifier = Modifier
        .then(modifier)
        .padding(top = 24.dp)
        .clip(RoundedCornerShape(4.dp))
        .clickable { }
        .padding(4.dp)) {
        Text(
            text = currentLanguage,
            style = ZorGoTypography.buttonLink.medium,
        )
        Spacer(modifier = Modifier.width(6.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_chevron_down),
            contentDescription = "ic_chevron_down",
            colorFilter = ColorFilter.tint(LocalContentColor.current)
        )
    }
}
