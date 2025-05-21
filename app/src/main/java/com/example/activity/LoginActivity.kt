package com.example.activity

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var usernameInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var loginButton: Button
    private lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        usernameInput = findViewById(R.id.editTextUsername)
        passwordInput = findViewById(R.id.editTextPassword)
        loginButton = findViewById(R.id.buttonLogin)
        preferences = getSharedPreferences("user_prefs", MODE_PRIVATE)

        // Auto-login if already logged in
        if (preferences.getBoolean("is_logged_in", false)) {
            startActivity(Intent(this, PopupActivity::class.java))
            finish()
            return
        }

        loginButton.setOnClickListener {
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                preferences.edit()
                    .putString("username", username)
                    .putBoolean("is_logged_in", true)
                    .apply()

                // Always show PopupActivity first
                startActivity(Intent(this, PopupActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Enter both fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
