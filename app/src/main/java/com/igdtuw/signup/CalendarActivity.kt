package com.igdtuw.signup

import android.annotation.SuppressLint
import android.app.TimePickerDialog
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import org.json.JSONArray
import java.util.*

class CalendarActivity : AppCompatActivity() {
    private val tasks = mutableListOf<String>() // List to store tasks/events
    private lateinit var sharedPreferences: SharedPreferences
    private var selectedTime = "" // Variable to store selected time

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calendar)

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("ScheduledTasks", MODE_PRIVATE)
        loadTasks() // Load saved tasks when app starts

        // Toolbar setup
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        // CalendarView setup
        val calendarView = findViewById<CalendarView>(R.id.calendarView)
        var selectedDate = ""
        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            selectedDate = "$dayOfMonth/${month + 1}/$year"
            Toast.makeText(this, "Selected Date: $selectedDate", Toast.LENGTH_SHORT).show()
        }

        // TimePicker setup
        val timePickerButton = findViewById<Button>(R.id.timePickerButton)
        timePickerButton.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            val timePickerDialog = TimePickerDialog(this, { _, selectedHour, selectedMinute ->
                selectedTime = String.format("%02d:%02d", selectedHour, selectedMinute)
                Toast.makeText(this, "Selected Time: $selectedTime", Toast.LENGTH_SHORT).show()
            }, hour, minute, true)
            timePickerDialog.show()
        }

        // Task/Event scheduling setup
        val taskInput = findViewById<EditText>(R.id.taskInput)
        val scheduleButton = findViewById<Button>(R.id.scheduleButton)
        scheduleButton.setOnClickListener {
            val task = taskInput.text.toString()
            if (selectedDate.isNotEmpty() && selectedTime.isNotEmpty() && task.isNotEmpty()) {
                val taskEntry = "$selectedDate at $selectedTime: $task"
                tasks.add(taskEntry)
                saveTasks() // Save tasks to SharedPreferences
                Toast.makeText(this, "Task scheduled for $taskEntry", Toast.LENGTH_SHORT).show()
                taskInput.text.clear() // Clear the input field
            } else {
                Toast.makeText(this, "Please select a date, time, and enter a task.", Toast.LENGTH_SHORT).show()
            }
        }

        // Navigate to the task list page
        val viewTasksButton = findViewById<Button>(R.id.viewTasksButton)
        viewTasksButton.setOnClickListener {
            val intent = Intent(this, CalendarActivity2::class.java)
            intent.putStringArrayListExtra("tasks", ArrayList(tasks)) // Pass the tasks
            startActivity(intent)
        }
    }

    // Save tasks to SharedPreferences
    private fun saveTasks() {
        val editor = sharedPreferences.edit()
        val jsonArray = JSONArray(tasks)
        editor.putString("tasks", jsonArray.toString())
        editor.apply()
    }

    // Load tasks from SharedPreferences
    private fun loadTasks() {
        val savedTasks = sharedPreferences.getString("tasks", null)
        if (!savedTasks.isNullOrEmpty()) {
            val jsonArray = JSONArray(savedTasks)
            for (i in 0 until jsonArray.length()) {
                tasks.add(jsonArray.getString(i))
            }
        }
    }
}