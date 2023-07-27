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
                showMainPage(username)
            } else {
                val errorMessage = "Falscher Name oder Passwort!"
                binding.loginTv.text = errorMessage
                Log.d("testlog", "login!")
            }
        }
    }

    private val userList: MutableList<Pair<String, String>> = mutableListOf(
        Pair("admin", "1234"),
        Pair("alex", "password1"),
        Pair("andreas", "password2"),
        Pair("ingo", "password3")
    )

    private fun isValidLogin(username: String, password: String): Boolean {
        for (user in userList) {
            if (user.first == username && user.second == password) {
                return true // Login gültig
            }
        }
        return false // Login ungültig
    }

    private fun showMainPage(username: String) {
        val intent = Intent(this, HomeActivity::class.java)
        intent.putExtra("username", username)
        startActivity(intent)
        finish() // Beende die com.example.loginapp.MainActivity, damit der Benutzer nicht zurücknavigieren kann
    }
}
