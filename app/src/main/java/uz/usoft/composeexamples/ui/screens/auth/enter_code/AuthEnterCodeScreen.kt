package uz.usoft.composeexamples.ui.screens.auth.enter_code

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import uz.usoft.composeexamples.R
import uz.usoft.composeexamples.ui.basic_components.app_bars.BasicTopAppBar
import uz.usoft.composeexamples.ui.basic_components.buttons.ButtonSizeType
import uz.usoft.composeexamples.ui.basic_components.buttons.LinkButton
import uz.usoft.composeexamples.ui.basic_components.buttons.PrimaryButton
import uz.usoft.composeexamples.ui.basic_components.text_fields.ZorGoTextField
import uz.usoft.composeexamples.ui.navigation.Screen
import uz.usoft.composeexamples.ui.screens.auth.BoxWithAuthBackground
import uz.usoft.composeexamples.ui.theme.ZorGoTypography

@Composable
fun AuthEnterCodeScreen(
    phoneNumber: String,
    navController: NavController,
    viewModel: EnterCodeViewModel = viewModel(),
) {
    val onNavigateFillProfile = {
        navController.navigate(Screen.Auth.AuthFillProfile.screenName) {
            popUpTo(Screen.Auth.AuthEnterPhone.screenName)
        }
    }

    val uiState = viewModel.uiState

    BoxWithAuthBackground {
        Column() {
            BasicTopAppBar(
                name = stringResource(R.string.authorization),
                onBackClicked = { navController.popBackStack() },
            )

            Text(
                text = "На номер $phoneNumber\nотправлено СМС сообщение.\nПожалуйста, введите\nотправленный код",
                style = ZorGoTypography.body.body1,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            ZorGoTextField(
                value = uiState.code,
                onValueChange = viewModel::setCode,
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number, imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext = { viewModel.verify(onNavigateFillProfile) }),
                label = { Text(text = stringResource(R.string.enter_code)) },
                placeholder = { Text(text = "----") },
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                LinkButton(text = "Отправить заново",
                    buttonSizeType = ButtonSizeType.Large,
                    onClick = {})
                Spacer(modifier = Modifier.weight(1f))
                PrimaryButton(
                    text = stringResource(R.string.next),
                    onClick = { viewModel.verify(onNavigateFillProfile) },
                    enabled = uiState.isNextButtonActive,
                    isLoading = uiState.isLoading,
                )
            }
        }
    }
}