package com.igdtuw.signup

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class GroupChat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Use the correct layout file for this activity
        setContentView(R.layout.group_chat2)

        // Get the group name passed from GroupChatActivity
        val groupName = intent.getStringExtra("group_name") ?: "Unnamed Group" // Default value if null
        val sendButton = findViewById<ImageView>(R.id.send_button)
        val messageInput = findViewById<EditText>(R.id.message_input)
        val messageContainer = findViewById<LinearLayout>(R.id.message_container)
        val scrollView = findViewById<ScrollView>(R.id.message_scroll)

        // Initialize and set group name dynamically
        val groupNameTextView = findViewById<TextView>(R.id.group_name)
        groupNameTextView.text = groupName

        // Back button to return to GroupChatActivity
        val backArrow = findViewById<ImageView>(R.id.back_arrow)
        backArrow.setOnClickListener {
            finish() // Go back to the group chat list
        }
        sendButton.setOnClickListener {
            val messageText = messageInput.text.toString()
            if (messageText.isNotEmpty()) {
                // Create a new TextView for the sent message
                val sentMessageView = TextView(this).apply {
                    text = messageText
                    setPadding(20, 20, 20, 20) // Increased padding for better appearance
                    setBackgroundResource(R.drawable.sent_message_bg) // Drawable for bubble styling
                    setTextColor(Color.BLACK) // Set text color to black
                    layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    ).apply {
                        setMargins(10, 10, 10, 10) // Added some space around the bubble
                        gravity = Gravity.END // Align to the right
                    }
                }

                // Add the new message to the container
                messageContainer.addView(sentMessageView)

                // Clear the input field
                messageInput.text.clear()

                // Scroll to the bottom to display the latest message
                scrollView.post {
                    scrollView.fullScroll(View.FOCUS_DOWN)
                }
            } else {
                // Optional: Show a message or warning when the input is empty
                Toast.makeText(this, "Please type a message!", Toast.LENGTH_SHORT).show()
            }
        }
    }

}

class GroupChatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the main group chat layout
        setContentView(R.layout.activity_group_chat)

        // Define sample group names
        val groupChats = listOf("Family Group", "Friends Group", "Work Group", "Hobby Group")

        // Initialize ListView and adapter for group chats
        val groupsListView = findViewById<ListView>(R.id.groups_list_view)

        // Use custom layout for ListView items
        val adapter = ArrayAdapter(this, R.layout.customcolor, R.id.item_name, groupChats)
        groupsListView.adapter = adapter

        // Handle selection of a group
        groupsListView.setOnItemClickListener { _, _, position, _ ->
            val selectedGroup = groupChats[position]

            // Create intent to navigate to GroupSpecificChatActivity
            val intent = Intent(this, GroupChat::class.java)
            intent.putExtra("group_name", selectedGroup) // Pass the selected group name
            startActivity(intent)
        }
    }
}


