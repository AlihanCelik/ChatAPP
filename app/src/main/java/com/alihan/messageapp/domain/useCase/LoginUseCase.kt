package com.alihan.messageapp.domain.useCase

import com.alihan.messageapp.data.model.UserModel
import com.alihan.messageapp.domain.repository.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String): Result<UserModel> {
        return repository.login(email, password)
    }
}

class RegisterUseCase @Inject constructor(private val repository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String): Result<UserModel> {
        return repository.register(email, password)
    }
}

class LogoutUseCase @Inject constructor(private val repository: AuthRepository) {
    operator fun invoke() {
        repository.logout()
    }
}
