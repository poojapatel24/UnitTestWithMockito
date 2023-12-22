package com.pooja.unittestwithmockito.repository

import com.pooja.unittestwithmockito.model.LOGIN_STATUS
import com.pooja.unittestwithmockito.model.User

class UserRepository {

    val users = listOf<User>(
        User(1, "Mona", "Mona@gmail.com", "123456"),
        User(2, "Rahul", "Rahul@gmail.com", "123456")
    )

    fun loginUser(email:String,password:String):LOGIN_STATUS{
        //fetch the user from db or server
        val user=users.filter { user -> user.emailId == email }
        return if(user.size == 1){
            if(user[0].password == password){
                LOGIN_STATUS.SUCCESS
            }else{
                LOGIN_STATUS.INVALID_PASSWORD
            }
        }else{
            LOGIN_STATUS.INVALID_USER
        }
    }
}