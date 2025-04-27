package com.igdtuw.signup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.content.Intent


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity) // Ensure this matches your Login Page XML
        // Find the Login Button
        val loginButton = findViewById<Button>(R.id.loginButton)

        // Set a Click Listener
        loginButton.setOnClickListener {
            // Navigate to Home Page
            val intent = Intent(this@LoginActivity, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}



