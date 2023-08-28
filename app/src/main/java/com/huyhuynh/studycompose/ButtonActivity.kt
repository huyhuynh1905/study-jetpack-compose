package com.huyhuynh.studycompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.huyhuynh.studycompose.ui.theme.StudyComposeTheme

class ButtonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudyComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ButtonScreens()
                }
            }
        }
    }
}

@Composable
fun ButtonScreens(){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)) {
        SimpleButton()
        OutlinedButton(onClick = {}) {
            Text(text = "OutLine")
        }
        ElevationButton()
        TextButton(onClick = { /*TODO*/ }) {
            Text("Text Button")
        }
    }
}

@Composable
fun SimpleButton(){
    Button(
        onClick = {
            Log.d("Click Button","Clicked")
        },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFFDA5858), //bgr color
            contentColor = Color.White, //nội dung như text color
        )
    ) {
        Text(text = "Click", color = Color.Green)
    }
}

@Composable
fun ElevationButton(){
    Button(onClick = {}, elevation = ButtonDefaults.elevation(
        defaultElevation = 5.dp
    )) {
        Text("Elevated")
    }
}





@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreviewButtonActivity() {
    StudyComposeTheme {
        ButtonScreens()
    }
}