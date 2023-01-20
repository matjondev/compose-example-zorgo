package uz.usoft.composeexamples.ui.screens.main.home.main

import androidx.compose.foundation.*
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import uz.usoft.composeexamples.R
import uz.usoft.composeexamples.ui.basic_components.app_bars.AppBarWithNotificationAction
import uz.usoft.composeexamples.ui.navigation.Screen
import uz.usoft.composeexamples.ui.screens.auth.BoxWithMainBackground
import uz.usoft.composeexamples.ui.theme.*

@Composable
fun MainPage(navController: NavController) {
    val scrollState = rememberScrollState()
    BoxWithMainBackground {
        Column() {
            AppBarWithNotificationAction(
                name = stringResource(R.string.project_name),
                onNotificationClicked = {}
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(scrollState)
                    .padding(horizontal = 16.dp, vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Item(
                    title = stringResource(R.string.car_incurance),
                    subtitle = stringResource(R.string.car_incurance_desc),
                    painter = painterResource(id = R.drawable.car_insurance),
                    modifier = Modifier.weight(1f),
                    onClick = { navController.navigate(Screen.Main.CarInsurance.screenName) }
                )
                Item(
                    title = stringResource(R.string.tranvel),
                    subtitle = stringResource(R.string.car_incurance_desc),
                    painter = painterResource(id = R.drawable.travel),
                    modifier = Modifier.weight(1f),
                    onClick = {}
                )
                Item(
                    title = stringResource(R.string.pdd_pains),
                    subtitle = stringResource(R.string.car_incurance_desc),
                    painter = painterResource(id = R.drawable.car_insurance),
                    modifier = Modifier.weight(1f),
                    onClick = {}
                )
                Item(
                    title = stringResource(R.string.market_place),
                    subtitle = stringResource(R.string.car_incurance_desc),
                    painter = painterResource(id = R.drawable.marketpleys_banner),
                    modifier = Modifier.weight(1f),
                    onClick = {}
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
    Row(
        modifier = Modifier
            .then(modifier)
            .height(128.dp)
            .clip(RoundedCornerShape(28.dp))
            .background(Blue50)
            .clickable(onClick = onClick)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painter,
            contentDescription = "",
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(text = title, style = ZorGoTypography.headlines.h4, color = Gray900)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = subtitle, style = ZorGoTypography.body.body3, color = Gray700)
        }
    }
}