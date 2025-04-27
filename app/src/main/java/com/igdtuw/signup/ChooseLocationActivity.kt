package com.igdtuw.signup

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import androidx.cardview.widget.CardView

class ChooseLocationActivity: AppCompatActivity() {

        @SuppressLint("MissingInflatedId")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.location)


            val sunsetCafe = findViewById<CardView>(R.id.sunsetCafeCard)
            val sportsAcademy = findViewById<CardView>(R.id.sportsAcademyCard)
            val mochaCafe = findViewById<CardView>(R.id.mochaCafeCard)



            sunsetCafe.setOnClickListener {
                val intent = Intent(this, SunsetCafeActivity::class.java)
                startActivity(intent)
            }

            sportsAcademy.setOnClickListener {
                val intent = Intent(this, SportsAcademyActivity::class.java)
                startActivity(intent)
            }
        }
    }
