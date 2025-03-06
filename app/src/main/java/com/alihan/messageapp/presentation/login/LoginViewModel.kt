package com.alihan.messageapp.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alihan.messageapp.data.model.UserModel
import com.alihan.messageapp.domain.useCase.LoginUseCase
import com.alihan.messageapp.domain.useCase.LogoutUseCase
import com.alihan.messageapp.domain.useCase.RegisterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val registerUseCase: RegisterUseCase,
    private val logoutUseCase: LogoutUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<AuthState>(AuthState.Idle)
    val uiState: StateFlow<AuthState> = _uiState

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _uiState.value = AuthState.Loading
            val result = loginUseCase(email, password)
            _uiState.value = if (result.isSuccess) AuthState.Success(result.getOrNull()) else AuthState.Error(result.exceptionOrNull()?.message ?: "Giriş başarısız")
        }
    }

    fun register(email: String, password: String) {
        viewModelScope.launch {
            _uiState.value = AuthState.Loading
            val result = registerUseCase(email, password)
            _uiState.value = if (result.isSuccess) AuthState.Success(result.getOrNull()) else AuthState.Error(result.exceptionOrNull()?.message ?: "Kayıt başarısız")
        }
    }

    fun logout() {
        logoutUseCase()
        _uiState.value = AuthState.Idle
    }
}

sealed class AuthState {
    object Idle : AuthState()
    object Loading : AuthState()
    data class Success(val user: UserModel?) : AuthState()
    data class Error(val message: String) : AuthState()
}