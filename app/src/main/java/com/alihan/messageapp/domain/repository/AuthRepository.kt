package com.alihan.messageapp.domain.repository

import com.alihan.messageapp.data.model.UserModel

interface AuthRepository {

    suspend fun login(email: String, password: String): Result<UserModel>
    suspend fun register(email: String, password: String): Result<UserModel>
    fun logout()
    fun getCurrentUser(): UserModel?

}
