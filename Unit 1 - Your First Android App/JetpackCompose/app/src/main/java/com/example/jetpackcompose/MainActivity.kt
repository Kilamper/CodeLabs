package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    JetpackContent()
                }
            }
        }
    }
}

@Composable
fun JetpackContent() {
    Column(modifier = Modifier.fillMaxSize()) {
        JetpackImage(
            modifier = Modifier
                .align(Alignment.Start)
                .fillMaxWidth()
        )
        JetpackTitle(
            title = stringResource(R.string.jetpack_title),
            modifier = Modifier.padding(16.dp)
        )
        JetpackText(
            text = stringResource(R.string.jetpack_text1),
            modifier = Modifier.padding(16.dp)
        )
        JetpackText(
            text = stringResource(R.string.jetpack_text2),
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun JetpackImage(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.bg_compose_background),
        contentDescription = "Jetpack Compose",
        modifier = modifier
    )
}

@Composable
fun JetpackTitle(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        fontSize = 24.sp,
        modifier = modifier
    )
}

@Composable
fun JetpackText(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        textAlign = TextAlign.Justify,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun JetpackPreview() {
    JetpackComposeTheme {
        JetpackContent()
    }
}