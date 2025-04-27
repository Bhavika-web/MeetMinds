package com.igdtuw.signup

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the Login Button
        val loginButton = findViewById<Button>(R.id.loginButton)

        // Set a Click Listener for Navigation
        loginButton.setOnClickListener {
            // Intent to navigate to Login Page
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
        }
        val signupButton = findViewById<Button>(R.id.signupButton)
        signupButton.setOnClickListener {
            val intent = Intent(this@MainActivity, SignupActivity::class.java)
            startActivity(intent)
        }
    }
}