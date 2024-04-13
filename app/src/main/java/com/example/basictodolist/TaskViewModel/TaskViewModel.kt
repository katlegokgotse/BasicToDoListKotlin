package com.example.basictodolist.TaskViewModel

import androidx.compose.runtime.mutableStateOf
import com.example.basictodolist.Model.Tasks

class TaskViewModel {
    var taskState = mutableStateOf(Tasks())
    fun addingATask(newTask: String){
        //The .copy() function to copy an object, which will allow you alter some of the
        //task properties while keeping the rest of the properties unchanged
        taskState.value = taskState.value.copy(id = taskState.value.id + 1, tasks = newTask)
    }
    fun updateTask(newTask: String){
        taskState.value = taskState.value.copy(tasks = newTask)
    }
}