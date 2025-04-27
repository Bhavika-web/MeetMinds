package com.igdtuw.signup

import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import android.content.Intent


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)
        Log.d("HomeActivity", "Layout loaded successfully")


        // Profile button click listener
        val profileButton: ImageButton = findViewById(R.id.profile_button)
        profileButton.setOnClickListener {
            Toast.makeText(this, "Profile clicked", Toast.LENGTH_SHORT).show()
        }

        // Logout button click listener
        val logoutButton: ImageButton = findViewById(R.id.logout_button)
        logoutButton.setOnClickListener {
            Toast.makeText(this, "Logout clicked", Toast.LENGTH_SHORT).show()
        }

        // Navigate to Calendar Page
        val calendarTextView = findViewById<TextView>(R.id.calendar)
        calendarTextView.setOnClickListener {
            val intent = Intent(this@HomeActivity, CalendarActivity::class.java)
            startActivity(intent)
        }

        // Navigate to Choose group Page
        val chooseGroupTextView = findViewById<TextView>(R.id.choose_group)
        chooseGroupTextView.setOnClickListener {
            val intent = Intent(this@HomeActivity, ChooseGroupActivity::class.java)
            startActivity(intent)
        }

        // Navigate to Choose location Page
        val chooseLocationTextView = findViewById<TextView>(R.id.choose_location)
        chooseLocationTextView.setOnClickListener {
            val intent = Intent(this@HomeActivity, ChooseLocationActivity::class.java)
            startActivity(intent)
        }

        // Navigate to Choose preferences Page
        val changePreferencesTextView = findViewById<TextView>(R.id.change_preferences)
        changePreferencesTextView.setOnClickListener {
            val intent = Intent(this@HomeActivity, Hobbies1ActivityMain::class.java)
            startActivity(intent)
        }

        // Navigate to Chats Page
        val myChatsTextView = findViewById<TextView>(R.id.my_chats)
        myChatsTextView.setOnClickListener {
            val intent = Intent(this@HomeActivity, ChatFront::class.java)
            startActivity(intent)
        }





    }
}
