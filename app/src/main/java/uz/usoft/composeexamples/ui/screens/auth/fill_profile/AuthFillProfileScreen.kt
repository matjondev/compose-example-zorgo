package uz.usoft.composeexamples.ui.screens.auth.fill_profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import uz.usoft.composeexamples.R
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import uz.usoft.composeexamples.ui.basic_components.app_bars.BasicTopAppBar
import uz.usoft.composeexamples.ui.basic_components.buttons.PrimaryButton
import uz.usoft.composeexamples.ui.basic_components.radio_button.ZorGoRadioButton
import uz.usoft.composeexamples.ui.basic_components.text_fields.ZorGoTextField
import uz.usoft.composeexamples.ui.navigation.Screen
import uz.usoft.composeexamples.ui.screens.auth.BoxWithAuthBackground
import uz.usoft.composeexamples.ui.theme.ZorGoTypography

@Composable
fun AuthFillProfileScreen(
    navController: NavController,
    viewModel: FillProfileViewModel = viewModel(),
//    onNavIconClicked: () -> Unit,
//    onNavigateToMainScreen: () -> Unit
) {
    val uiState = viewModel.uiState
    val focusManager = LocalFocusManager.current

    BoxWithAuthBackground {
        Column() {
            BasicTopAppBar(
                name = stringResource(R.string.authorization),
                onBackClicked = { navController.popBackStack() },
            )

            Spacer(modifier = Modifier.height(16.dp))

            ZorGoTextField(
                value = uiState.name,
                onValueChange = viewModel::setName,
                modifier = Modifier.padding(horizontal = 16.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text, imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down) }),
                label = { Text(text = stringResource(R.string.name)) },
            )

            Spacer(modifier = Modifier.height(16.dp))

            ZorGoTextField(
                value = uiState.surname,
                onValueChange = viewModel::setSurname,
                modifier = Modifier.padding(horizontal = 16.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text, imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down) }),
                label = { Text(text = stringResource(R.string.name)) },
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ZorGoRadioButton(
                    selected = uiState.isUserAgreed, onClick = viewModel::setUserAgreed
                )
                Text(
                    text = stringResource(R.string.user_agreement),
                    style = ZorGoTypography.body.body3
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            PrimaryButton(
                text = stringResource(R.string.save),
                onClick = {
                    viewModel.saveData {
                        navController.navigate(Screen.Main.screenName) {
                            popUpTo(Screen.Auth.AuthEnterPhone.screenName) { inclusive = true }
                        }
                    }
                },
                modifier = Modifier.align(Alignment.End),
                enabled = uiState.isSaveButtonActive,
                isLoading = uiState.isLoading,
            )
        }
    }

}