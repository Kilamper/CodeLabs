package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xffd2e8d4)
                ) {
                    BusinessCardContent()
                }
            }
        }
    }
}

@Composable
fun BusinessCardContent() {
    BusinessCardMainSection(
        title = "Jennifer Doe",
        subtitle = "Android Developer Extraordinaire",
    )
    BusinessCardFooter(
        phoneNumber = "+11 (123) 444 555 666",
        link = "@AndroidDev",
        email = "jen.doe@android.com"
    )
}

@Composable
fun BusinessCardMainSection(title: String, subtitle: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = "Android Logo",
            modifier = Modifier
                .background(Color(0xff073042))
                .padding(8.dp)
                .width(110.dp)
        )
        Text(
            text = title,
            fontWeight = FontWeight.Light,
            fontSize = 48.sp,
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
        )
        Text(
            text = subtitle,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xff006a36)
        )
    }
}

@Composable
fun BusinessCardFooter(
    phoneNumber: String,
    link: String,
    email: String,
) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(bottom = 32.dp)
    ) {
        Row(
            modifier = Modifier.width(220.dp).padding(bottom = 8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.phone),
                contentDescription = "Phone",
                modifier = Modifier.padding(end = 16.dp),
                tint = Color(0xff006a36)
            )
            Text(
                text = phoneNumber
            )
        }
        Row(
            modifier = Modifier.width(220.dp).padding(bottom = 8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.share),
                contentDescription = "Link",
                modifier = Modifier.padding(end = 16.dp),
                tint = Color(0xff006a36)
            )
            Text(
                text = link
            )
        }
        Row(
            modifier = Modifier.width(220.dp).padding(bottom = 8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.mail),
                contentDescription = "Email",
                modifier = Modifier.padding(end = 16.dp),
                tint = Color(0xff006a36)
            )
            Text(
                text = email
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCardContent()
    }
}