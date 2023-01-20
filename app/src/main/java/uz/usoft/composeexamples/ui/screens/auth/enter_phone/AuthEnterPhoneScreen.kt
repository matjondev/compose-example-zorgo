package uz.usoft.composeexamples.ui.screens.auth.enter_phone

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import uz.usoft.composeexamples.R
import uz.usoft.composeexamples.ui.basic_components.app_bars.BasicTopAppBar
import uz.usoft.composeexamples.ui.basic_components.buttons.PrimaryButton
import uz.usoft.composeexamples.ui.basic_components.text_fields.ZorGoTextField
import uz.usoft.composeexamples.ui.navigation.Screen
import uz.usoft.composeexamples.ui.screens.auth.BoxWithAuthBackground
import uz.usoft.composeexamples.ui.theme.ZorGoTypography
import uz.usoft.composeexamples.utils.PhoneNumberVisualTransformation

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AuthEnterPhoneScreen(
    navController: NavController,
    viewModel: EnterPhoneViewModel = viewModel(),
) {

    val onNavigateToEnterCodeScreen: (String) -> Unit = {
        navController.navigate(
            Screen.Auth.AuthEnterCode.addArg(it),
        )
    }

    val uiState = viewModel.uiState

    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()

    val visualTransformation =
        if (isFocused || uiState.phoneNumber.text.isNotBlank()) PhoneNumberVisualTransformation() else VisualTransformation.None

    LocalFocusManager.current.moveFocus(FocusDirection.Enter)

    BoxWithAuthBackground {
        Column() {
            BasicTopAppBar(name = stringResource(R.string.authorization))

            Text(
                text = "Для авторизации введите\n ваш номер телефона",
                style = ZorGoTypography.body.body1,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            ZorGoTextField(
                value = uiState.phoneNumber,
                onValueChange = viewModel::setPhoneNumber,
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Next
                ),
                label = { Text(text = stringResource(R.string.phone_number)) },
                placeholder = { Text(text = "+998 -- --- -- --") },
                keyboardActions = KeyboardActions(onNext = {
                    viewModel.sendCode {
                        onNavigateToEnterCodeScreen(
                            viewModel.getFormattedPhoneNumber()
                        )
                    }
                }),
                interactionSource = interactionSource,
                visualTransformation = visualTransformation
            )

            PrimaryButton(
                text = stringResource(R.string.next),
                onClick = { viewModel.sendCode { onNavigateToEnterCodeScreen(viewModel.getFormattedPhoneNumber()) } },
                enabled = uiState.isNextButtonActive,
                isLoading = uiState.isLoading,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(top = 16.dp, end = 16.dp)
            )

        }

    }
}