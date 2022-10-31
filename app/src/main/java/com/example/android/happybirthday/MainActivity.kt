package com.example.android.happybirthday

import android.graphics.Color
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BirthdayGreetingWithImage(message = getString(R.string.happy_birthday_text), from =getString(
                                            R.string.signature_text) )

                }
            }
        }
    }
}

@Composable
fun BirthdayGreetingWithImage(message: String, from: String){
    val image = painterResource(R.drawable.androidparty)
    //create a box to overlap image and texts
    Box {
        Image(painter = image, contentDescription = "Android Party Image", modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(), contentScale = ContentScale.Crop)
        BirthdayGreetingWithText(message , from)
    }
}

@Composable
fun BirthdayGreetingWithText(message: String, from:String){

        Column() {
            Text(message, fontSize = 36.sp, modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(start = 16.dp, top = 16.dp))
            Text(from, fontSize = 24.sp, modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(start = 16.dp, end= 16.dp))
        }
}

@Preview(showBackground = false)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme{
       BirthdayGreetingWithImage(message = "Happy Birthday Sam!", from = "- from Ben")
    }
}
