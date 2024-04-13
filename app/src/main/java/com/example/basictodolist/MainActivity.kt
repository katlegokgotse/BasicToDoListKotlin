package com.example.basictodolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basictodolist.TaskViewModel.TaskViewModel
import com.example.basictodolist.ui.theme.BasicToDoListTheme

class MainActivity : ComponentActivity() {
    private val tasksViewModel = TaskViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            BasicToDoListTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UserInput(tasksViewModel = tasksViewModel)
                }
            }
        }
    }
}

@Composable
fun UserInput(tasksViewModel: TaskViewModel){
    Column (modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center)
    {
        Row(
            horizontalArrangement = Arrangement.Center
        )
        {
            TextField(value = tasksViewModel.taskState.value.toString(),
                onValueChange = { newValue ->
                    // Update the value in the ViewModel
                    tasksViewModel.updateTask(newValue)
                },
                modifier = Modifier.padding(20.dp)
            )
            //Text(text = "Add Tasks", modifier = Modifier.padding(8.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    tasksViewModel.addingATask("New Task")
                }) {
                 //   Text(text = "Add Tasks")
            }
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    val sampleViewModel = TaskViewModel()
    BasicToDoListTheme {
        UserInput(tasksViewModel = sampleViewModel)
    }
}