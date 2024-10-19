package com.example.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TaskManagerContent()
                }
            }
        }
    }
}

@Composable
fun TaskManagerContent() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CompleteIcon()
        CompleteText(
            text = stringResource(R.string.complete_text),
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
        )
        CongratulationsMessage(
            message = stringResource(R.string.congratulations_message)
        )
    }
}

@Composable
fun CompleteIcon() {
    Image(
        painter = painterResource(id = R.drawable.ic_task_completed),
        contentDescription = "Complete Icon",
    )
}

@Composable
fun CompleteText(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        fontWeight = FontWeight.Bold,
        modifier = modifier
    )
}

@Composable
fun CongratulationsMessage(message: String, modifier: Modifier = Modifier) {
    Text(
        text = message,
        fontSize = 16.sp,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun TaskManagerPreview() {
    TaskManagerTheme {
        TaskManagerContent()
    }
}