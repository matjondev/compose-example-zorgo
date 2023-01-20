package uz.usoft.composeexamples.ui.screens.auth.enter_code

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EnterCodeViewModel @Inject constructor() : ViewModel() {
    var uiState by mutableStateOf(EnterCodeUIState())
        private set

    fun setCode(code: TextFieldValue) {
        if (code.text.length <= 4) {
            uiState = uiState.copy(code = code)
        }
        uiState = uiState.copy(isNextButtonActive = uiState.code.text.length == 4)
    }

    fun verify(action: () -> Unit) {
        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true)
            delay(1000)
            uiState = uiState.copy(isLoading = false)
            action()
        }
    }
}

data class EnterCodeUIState(
    val code: TextFieldValue = TextFieldValue(""),
    val isNextButtonActive: Boolean = false,
    val isLoading: Boolean = false,
)
