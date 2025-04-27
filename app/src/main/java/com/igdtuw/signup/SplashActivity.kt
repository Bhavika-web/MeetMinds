package com.igdtuw.signup

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity: AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.splash_screen)

            // Delay for 3 seconds before navigating to the main activity
            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish() // Prevent the user from coming back to the splash screen
            }, 3000) // 3000ms = 3 seconds
        }
    }
