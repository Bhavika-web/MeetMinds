package com.igdtuw.signup

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Hobbies2Activity: AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.hobbies2)

            // Back arrow navigation
            val backArrow = findViewById<ImageView>(R.id.backArrow) // Ensure back arrow ID matches XML
            backArrow.setOnClickListener {
                finish() // Navigate back to the previous activity
            }

            // Initialize buttons for specific sports
            val btnCricket = findViewById<Button>(R.id.btn_cricket)
            val btnBadminton = findViewById<Button>(R.id.btn_badminton)
            val btnTennis = findViewById<Button>(R.id.btn_tennis)
            val btnBasketball = findViewById<Button>(R.id.btn_basketball)

            // Set click listeners for each sport
            btnCricket.setOnClickListener {
                Toast.makeText(this, "You selected: Cricket", Toast.LENGTH_SHORT).show()
            }

            btnBadminton.setOnClickListener {
                Toast.makeText(this, "You selected: Badminton", Toast.LENGTH_SHORT).show()
            }

            btnTennis.setOnClickListener {
                Toast.makeText(this, "You selected: Tennis", Toast.LENGTH_SHORT).show()
            }

            btnBasketball.setOnClickListener {
                Toast.makeText(this, "You selected: Basketball", Toast.LENGTH_SHORT).show()
            }
        }
    }
