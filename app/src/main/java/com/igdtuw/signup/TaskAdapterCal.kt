package com.igdtuw.signup

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskAdapterCal(
    private val tasks: MutableList<String>, // MutableList for deletion
    private val onDeleteClick: (Int) -> Unit // Callback for delete action
) : RecyclerView.Adapter<TaskAdapterCal.TaskViewHolder>() {

    class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val taskTextView: TextView = view.findViewById(R.id.taskTextView)
        val deleteButton: ImageButton = view.findViewById(R.id.deleteButton) // Delete Button
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.taskTextView.text = tasks[position]
        holder.deleteButton.setOnClickListener {
            onDeleteClick(position) // Trigger delete callback
        }
    }

    override fun getItemCount(): Int {
        return tasks.size
    }
}