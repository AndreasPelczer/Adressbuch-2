package com.example.loginapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.loginapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener {
            val username = binding.editTextUsername.text.toString()
            val password = binding.editTextPassword.text.toString()

            val isValidLogin = isValidLogin(username, password)

            if (isValidLogin) {
                showMainPage()
            } else {
                val errorMessage = "Falscher name oder password!"
                binding.loginTv.text = errorMessage
                Log.d("testlog","login!")
            }
        }
    }

    private fun isValidLogin(username: String, password: String): Boolean {
        return username == "user" && password == "1234"
    }

    private fun showMainPage() {
        val username = ""
        val successMessage = "Erfolgreich eingeloggt!$username!"
        binding.loginTv.text = successMessage
    }
}
