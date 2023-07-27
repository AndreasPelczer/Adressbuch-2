package com.example.loginapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.loginapp.databinding.ProfileActivityBinding

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ProfileActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ProfileActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Benutzername aus den Intent-Extras abrufen
        val username = intent.getStringExtra("username")
        val successMessage = "Deine Einstellungen, $username"
        binding.welcomeProfile.text = successMessage

        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.profile -> {
                    val intent = Intent(this, UserProfil::class.java)
                    intent.putExtra("username", username)
                    startActivity(intent)
                    true
                }
                R.id.home -> {
                    val intent = Intent(this, HomeActivity::class.java)
                    intent.putExtra("username", username)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}
