package com.example.loginapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.loginapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Benutzername aus den Intent-Extras abrufen
        val username = intent.getStringExtra("username")

        // Begrüssungsnachricht anzeigen
        val successMessage = "Erfolgreich eingeloggt! Herzlich willkommen, $username!"
        binding.welcomeTextView.text = successMessage
    }
}
