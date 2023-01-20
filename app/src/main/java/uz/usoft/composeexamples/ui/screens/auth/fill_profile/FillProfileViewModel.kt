package uz.usoft.composeexamples.ui.screens.auth.fill_profile

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
class FillProfileViewModel @Inject constructor() : ViewModel() {
    var uiState by mutableStateOf(FillProfileUIState())
        private set

    fun setName(name: TextFieldValue) {
        uiState = uiState.copy(name = name).checkSaveButtonActive()
    }

    fun setSurname(surname: TextFieldValue) {
        uiState = uiState.copy(surname = surname).checkSaveButtonActive()
    }

    fun setUserAgreed() {
        uiState = uiState.copy(isUserAgreed = !uiState.isUserAgreed).checkSaveButtonActive()
    }

    fun saveData(action: () -> Unit) {
        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true)
            delay(1000)
            uiState = uiState.copy(isLoading = false)
            action()
        }
    }

    private fun FillProfileUIState.checkSaveButtonActive(): FillProfileUIState = copy(isSaveButtonActive = name.text.isNotBlank() && surname.text.isNotBlank() && isUserAgreed)

}

data class FillProfileUIState(
    val name: TextFieldValue = TextFieldValue(""),
    val surname: TextFieldValue = TextFieldValue(""),
    val isLoading: Boolean = false,
    val isUserAgreed: Boolean = false,
    val isSaveButtonActive: Boolean = name.text.isNotBlank() && surname.text.isNotBlank() && isUserAgreed,
)