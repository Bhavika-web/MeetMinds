package com.igdtuw.signup

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ChatFront: AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.front_chat)

        // Back button functionality
        val backButton = findViewById<ImageView>(R.id.back_button)
        backButton.setOnClickListener {
            finish()
        }

        // Names ListView with custom text color
        val namesListView = findViewById<ListView>(R.id.names_list_view)
        val names = listOf("Alice", "Bob", "Charlie", "David", "Eve")

        // Using a custom layout for list items (custom_list_item.xml)
        val adapter = ArrayAdapter(this, R.layout.customcolor, R.id.item_name, names)
        namesListView.adapter = adapter

        // Handle click events for list items
        namesListView.setOnItemClickListener { _, _, position, _ ->
            val selectedPerson = names[position] // Get selected person
            val intent = Intent(this, ChatInterface::class.java)
            intent.putExtra("person_name", selectedPerson)
            startActivity(intent) // Navigate to ChatInterfaceActivity
        }
        findViewById<Button>(R.id.chats_button).setOnClickListener {
            // Reload this activity, if needed
            recreate() // Optional, since you're already on this page
        }

        findViewById<Button>(R.id.groups_button).setOnClickListener {
            val intent = Intent(this, GroupChatActivity::class.java)
            startActivity(intent) // Navigate to GroupsActivity
        }





    }
}

