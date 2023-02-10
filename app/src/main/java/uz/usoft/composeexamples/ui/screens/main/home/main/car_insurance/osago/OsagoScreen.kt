package uz.usoft.composeexamples.ui.screens.main.home.main.car_insurance.osago

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.material.DropdownMenu
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import uz.usoft.composeexamples.R
import uz.usoft.composeexamples.ui.basic_components.app_bars.AppBarWithHelpAction
import uz.usoft.composeexamples.ui.basic_components.buttons.ButtonSizeType
import uz.usoft.composeexamples.ui.basic_components.buttons.LinkButton
import uz.usoft.composeexamples.ui.screens.auth.BoxWithMainBackground
import uz.usoft.composeexamples.ui.screens.main.home.main.car_insurance.HelpDialog

@Composable
fun OsagoScreen(navController: NavController) {
    var dialogVisible by remember { mutableStateOf(false) }
    var dropDownExpanded by remember { mutableStateOf(false) }
    BoxWithMainBackground {
        Column {
            AppBarWithHelpAction(
                name = stringResource(id = R.string.osago),
                onBackClicked = { navController.popBackStack() },
                onHelpClicked = { dialogVisible = true }
            )
            Surface() {
                
            }

            LinkButton(text = "dropDown", buttonSizeType = ButtonSizeType.Medium) {
                dropDownExpanded = true
            }

            DropdownMenu(expanded = dropDownExpanded, onDismissRequest = { dropDownExpanded = false  }) {
                repeat(4) {
                    Text(text = "item $it")
                }
            }
        }

        if (dialogVisible) {
            HelpDialog {
                dialogVisible = false
            }

        }
    }
}