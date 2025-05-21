package com.example.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)  // <- THIS IS CRUCIAL

        Handler(Looper.getMainLooper()).postDelayed({
            val preferences = getSharedPreferences("user_prefs", MODE_PRIVATE)
            val isLoggedIn = preferences.getBoolean("is_logged_in", false)

            val nextActivity = if (isLoggedIn) {
                PopupActivity::class.java
            } else {
                LoginActivity::class.java
            }

            startActivity(Intent(this, nextActivity))
            finish()
        }, 2000) // 2-second splash delay
    }
}
