package com.pooja.unittestwithmockito.viewmodel

import com.pooja.unittestwithmockito.model.LOGIN_STATUS.*
import com.pooja.unittestwithmockito.repository.UserRepository

class UserViewModel(private val userRepository: UserRepository) {
    fun loginUser(email: String, password: String): String {
        val status = userRepository.loginUser(email, password)
        return when (status) {
            INVALID_USER -> "User does not exit"
            INVALID_PASSWORD -> "Password is invalid"
            UNKNOWN_ERROR -> "Unknown Error"
            SUCCESS -> "Logged in successfully"
        }
    }
}