package uz.usoft.composeexamples.ui.screens.auth.enter_phone

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.usoft.composeexamples.utils.Constants
import javax.inject.Inject

@HiltViewModel
class EnterPhoneViewModel @Inject constructor() : ViewModel() {
    var uiState by mutableStateOf(EnterPhoneScreenUIState())
        private set

    fun setPhoneNumber(number: TextFieldValue) {
        if (number.text.length <= Constants.PHONE_NUMBER_LENGTH)
            uiState = uiState.copy(phoneNumber = number)

        uiState =
            uiState.copy(isNextButtonActive = uiState.phoneNumber.text.length == Constants.PHONE_NUMBER_LENGTH)
    }

    fun sendCode(action: () -> Unit) {
        if (uiState.isNextButtonActive) {
            // TODO: sendMessage
            viewModelScope.launch {
                uiState = uiState.copy(isLoading = true)
                delay(1000)
                uiState = uiState.copy(isLoading = false)
                action()
            }
        }

    }

    fun getFormattedPhoneNumber(): String {
        val number = uiState.phoneNumber.text
        return StringBuilder().apply {
            append("+998 ")
            append(number.substring(0..1))
            append(' ')
            append(number.substring(2..4))
            append(' ')
            append("*** **")
            append(' ')
            append(number.substring(7..8))

        }.toString()

    }

}

data class EnterPhoneScreenUIState(
    val phoneNumber: TextFieldValue = TextFieldValue(text = ""),
    val isNextButtonActive: Boolean = false,
    val isLoading: Boolean = false,
)