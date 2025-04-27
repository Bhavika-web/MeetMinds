package com.igdtuw.signup
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ChooseGroupActivity: AppCompatActivity()  {

      override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.groups_choose) // Ensure this matches the correct XML layout file.

            // Ensure the Back Button exists in the XML layout with the ID back_button.
            val backButton: Button? = findViewById(R.id.back_button)
            backButton?.setOnClickListener {
                Toast.makeText(this, "Going back...", Toast.LENGTH_SHORT).show()
                // Add navigation logic if required
            }

            // Group 1 Buttons
            val joinButton1: Button? = findViewById(R.id.join_button_1)
            val leaveButton1: Button? = findViewById(R.id.leave_button_1)
            joinButton1?.setOnClickListener {
                Toast.makeText(this, "You joined 'Study Buddies' group!", Toast.LENGTH_SHORT).show()
                // Add join logic
            }
            leaveButton1?.setOnClickListener {
                Toast.makeText(this, "You left 'Study Buddies' group!", Toast.LENGTH_SHORT).show()
                // Add leave logic
            }

            // Group 2 Buttons
            val joinButton2: Button? = findViewById(R.id.join_button_2)
            val leaveButton2: Button? = findViewById(R.id.leave_button_2)
            joinButton2?.setOnClickListener {
                Toast.makeText(this, "You joined 'Cricket Champs' group!", Toast.LENGTH_SHORT).show()
                // Add join logic
            }
            leaveButton2?.setOnClickListener {
                Toast.makeText(this, "You left 'Cricket Champs' group!", Toast.LENGTH_SHORT).show()
                // Add leave logic
            }
        }
    }
