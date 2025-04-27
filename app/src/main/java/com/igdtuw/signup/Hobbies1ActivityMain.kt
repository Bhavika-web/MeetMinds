package com.igdtuw.signup

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class Hobbies1ActivityMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.hobbies1)

            // Find buttons
            val btnSports = findViewById<Button>(R.id.btn_sports)
            val btnCooking = findViewById<Button>(R.id.btn_cooking)
            val btnTraveling = findViewById<Button>(R.id.btn_traveling)

            // Set click listeners
            btnSports.setOnClickListener {
                // Navigate to SportsActivity
                val intent = Intent(this, Hobbies2Activity::class.java)
                startActivity(intent)
            }

            btnCooking.setOnClickListener {
                // Show Toast for Cooking (or navigate to another activity if needed)
                Toast.makeText(this, "You selected: Cooking", Toast.LENGTH_SHORT).show()
            }

            btnTraveling.setOnClickListener {
                // Show Toast for Traveling (or navigate to another activity if needed)
                Toast.makeText(this, "You selected: Traveling", Toast.LENGTH_SHORT).show()
            }
        }
    }
