package com.example.loginapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.loginapp.adapter.ItemAdapter
import com.example.loginapp.data.DataSource
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
        val successMessage = "Herzlich willkommen, $username!"
        binding.welcomeTextView.text = successMessage

        val cans = DataSource().loadCanes()
        binding.recyclerView.adapter = ItemAdapter(this, cans)
        binding.recyclerView.setHasFixedSize(true)

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
                R.id.settings -> {
                    val intent = Intent(this, SettingsActivity::class.java)
                    intent.putExtra("username", username)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}
