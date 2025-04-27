package com.igdtuw.signup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.content.Intent

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_activity)

        // Find the Signup Button
        val signupButton = findViewById<Button>(R.id.signupButton)

        // Set a Click Listener
        signupButton.setOnClickListener {
            // Navigate to Home Page
            val intent = Intent(this@SignupActivity, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}



