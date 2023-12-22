package com.pooja.unittestwithmockito.viewmodel

import com.nhaarman.mockitokotlin2.anyOrNull
import com.pooja.unittestwithmockito.model.LOGIN_STATUS
import com.pooja.unittestwithmockito.repository.UserRepository
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations


class UserViewModelTest{

    @Mock
    lateinit var userRepository: UserRepository

    @Before
    fun setUp(){
        MockitoAnnotations.openMocks(this)
        Mockito.`when`(userRepository.loginUser(anyOrNull(), anyOrNull())).thenReturn(LOGIN_STATUS.INVALID_USER)
    }

    @Test
    fun testUserValid(){
        val userViewModel=UserViewModel(userRepository)
        val status=userViewModel.loginUser("test@gmail.com","123456")
        Assert.assertEquals("User does not exit",status)
    }
}