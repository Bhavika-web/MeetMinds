package com.igdtuw.signup


import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray

class CalendarActivity2 : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private val tasks = mutableListOf<String>() // MutableList for tasks/events

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calendar2)

        // Toolbar setup
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("ScheduledTasks", MODE_PRIVATE)
        loadTasks() // Load saved tasks

        // RecyclerView setup
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = TaskAdapterCal(tasks) { position ->
            tasks.removeAt(position) // Remove task from list
            saveTasks() // Save updated tasks to SharedPreferences
            recyclerView.adapter?.notifyItemRemoved(position) // Update RecyclerView
        }
        recyclerView.adapter = adapter
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