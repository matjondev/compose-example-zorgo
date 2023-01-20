package uz.usoft.composeexamples.ui.screens.main.home.main.car_insurance

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import uz.usoft.composeexamples.R
import uz.usoft.composeexamples.ui.basic_components.app_bars.AppBarWithNotificationAction
import uz.usoft.composeexamples.ui.navigation.Screen
import uz.usoft.composeexamples.ui.screens.auth.BoxWithMainBackground
import uz.usoft.composeexamples.ui.theme.Blue50
import uz.usoft.composeexamples.ui.theme.Gray700
import uz.usoft.composeexamples.ui.theme.Gray900
import uz.usoft.composeexamples.ui.theme.ZorGoTypography

@Composable
fun CarInsuranceScreen(navController: NavController) {
    BoxWithMainBackground {

        Column() {
            AppBarWithNotificationAction(
                name = stringResource(R.string.car_incurance),
                onBackClicked = { navController.popBackStack() },
                onNotificationClicked = {},
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp, vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Item(
                    title = stringResource(R.string.osago),
                    subtitle = stringResource(R.string.car_incurance_desc),
                    painter = painterResource(id = R.drawable.car_insurance),
                    onClick = { navController.navigate(Screen.Main.Osago.screenName) }
                )
                Item(
                    title = stringResource(R.string.kasko),
                    subtitle = stringResource(R.string.car_incurance_desc),
                    painter = painterResource(id = R.drawable.kacko),
                    onClick = { navController.navigate(Screen.Main.Kasko.screenName) }
                )
            }
        }
    }
}

@Composable
private fun Item(
    title: String,
    subtitle: String,
    painter: Painter,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .then(modifier)
            .clip(RoundedCornerShape(28.dp))
            .background(Blue50)
            .clickable(onClick = onClick)
            .padding(horizontal = 48.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painter,
            contentDescription = "",
            modifier = Modifier
                .size(width = 160.dp, height = 90.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = title, style = ZorGoTypography.headlines.h4, color = Gray900)
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = subtitle,
            style = ZorGoTypography.body.body3,
            color = Gray700,
            textAlign = TextAlign.Center
        )
    }
}