package uz.usoft.composeexamples.ui.screens.main.home.main.car_insurance.kasko

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import uz.usoft.composeexamples.R
import uz.usoft.composeexamples.ui.basic_components.app_bars.AppBarWithHelpAction
import uz.usoft.composeexamples.ui.screens.auth.BoxWithMainBackground

@Composable
fun KaskoScreen(navController: NavController) {
    BoxWithMainBackground {
        Column {
            AppBarWithHelpAction(
                name = stringResource(id = R.string.kasko),
                onBackClicked = { navController.popBackStack() },
                onHelpClicked = {}
            )
        }
    }
}