package com.pooja.unittestwithmockito

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.pooja.unittestwithmockito.databinding.ActivityMainBinding
import com.pooja.unittestwithmockito.repository.UserRepository
import com.pooja.unittestwithmockito.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var userViewModel:UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val userRepository=UserRepository()
        userViewModel=UserViewModel(userRepository)
        binding.btnLogin.setOnClickListener {
            val email=binding.etEmail.text.toString()
            val pwd=binding.etPassword.text.toString()
            val status=userViewModel.loginUser(email,pwd)
            Toast.makeText(applicationContext,status,Toast.LENGTH_LONG).show()
        }
    }
}