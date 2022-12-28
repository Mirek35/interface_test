package com.example.log_indicator.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SomeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(SomeState())
    val uiState: StateFlow<SomeState> = _uiState.asStateFlow()

    fun loginAttempt() {
        _uiState.update { currentState ->
            currentState.copy(loginState = nextLoginState(currentState.loginState))
        }
    }

    private fun nextLoginState(currentLoginState: LoginState): LoginState {
        return if (isLastDefinedState(currentLoginState)) {
            LoginState.FIRST
        } else {
            LoginState.values()[currentLoginState.ordinal + 1]
        }
    }

    private fun isLastDefinedState(currentLoginState: LoginState) =
        currentLoginState.ordinal == LoginState.values().size - 1
}
