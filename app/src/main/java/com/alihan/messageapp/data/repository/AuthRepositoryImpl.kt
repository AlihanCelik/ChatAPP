package com.alihan.messageapp.data.repository

import com.alihan.messageapp.data.model.UserModel
import com.alihan.messageapp.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor() : AuthRepository {

    override suspend fun login(email: String, password: String): Result<UserModel> {
        return try {
            if (email == "alihan" && password == "1234") {
                Result.success(UserModel("1", "alihan@example.com"))
            } else {
                Result.failure(Exception("Geçersiz giriş bilgileri!"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun register(email: String, password: String): Result<UserModel> {
        return try {
            Result.success(UserModel("2", email))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override fun logout() {
        println("Çıkış yapıldı.")
        //firebaseAuth.signOut()
    }

    override fun getCurrentUser(): UserModel? {
        return UserModel("1", "alihan@example.com")
    }
}
