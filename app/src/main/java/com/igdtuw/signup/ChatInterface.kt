package com.igdtuw.signup

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ChatInterface  : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_interface)

        // Initialize views
        val backArrow = findViewById<ImageView>(R.id.back_arrow)
        val voiceCallIcon = findViewById<ImageView>(R.id.voice_call_icon)
        val videoCallIcon = findViewById<ImageView>(R.id.video_call_icon)
        val messageInput = findViewById<EditText>(R.id.message_input)
        val sendButton = findViewById<ImageView>(R.id.send_button)
        val messageContainer = findViewById<LinearLayout>(R.id.message_container)
        val scrollView = findViewById<ScrollView>(R.id.scrollable_message_area)
        val personName = findViewById<TextView>(R.id.chat_person_name)

        // Get the person's name from the Intent passed from MainActivity
        val selectedPersonName = intent.getStringExtra("person_name")
        personName.text = selectedPersonName ?: "Unknown"

        // Back button action
        backArrow.setOnClickListener {
            finish() // Go back to the previous screen (MainActivity)
        }

        // Send button action
        sendButton.setOnClickListener {
            val userMessage = messageInput.text.toString()

            if (userMessage.isNotBlank()) {
                // Add user message to chat (on the right)
                addMessageToChat(messageContainer, userMessage, true)

                // Add reply (on the left)
                val reply = "This is a reply"
                addMessageToChat(messageContainer, reply, false)

                // Clear the input field
                messageInput.text.clear()

                // Auto-scroll to the latest message
                scrollView.post {
                    scrollView.fullScroll(View.FOCUS_DOWN)
                }
            }
        }

        // Voice call icon click action (placeholder)
        voiceCallIcon.setOnClickListener {
            // Handle voice call functionality
        }

        // Video call icon click action (placeholder)
        videoCallIcon.setOnClickListener {
            // Handle video call functionality
        }
    }

    private fun addMessageToChat(container: LinearLayout, message: String, isUser: Boolean) {
        val messageView = TextView(this)
        messageView.text = message
        messageView.textSize = 16f
        messageView.setPadding(20, 10, 20, 10)

        // Style messages differently based on sender
        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        ).apply {
            setMargins(10, 10, 10, 10) // Add spacing between messages
            gravity = if (isUser) Gravity.END else Gravity.START // Align based on sender
        }

        messageView.layoutParams = layoutParams

        if (isUser) {
            messageView.setBackgroundResource(R.drawable.sent_message_bg)
            messageView.setTextColor(Color.BLACK)
        } else {
            messageView.setBackgroundResource(R.drawable.recieved_message_bg)
            messageView.setTextColor(Color.BLACK)
        }

        container.addView(messageView)
    }
}

