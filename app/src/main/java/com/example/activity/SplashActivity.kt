package com.example.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Optional: set a splash screen layout
        setContentView(R.layout.activity_splash)


        // Delay then launch PopupActivity
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@SplashActivity, PopupActivity::class.java)
            startActivity(intent)
            finish() // Optional: finish Splash so user can't return to it
        }, 2000) // 2-second splash delay
    }
}
