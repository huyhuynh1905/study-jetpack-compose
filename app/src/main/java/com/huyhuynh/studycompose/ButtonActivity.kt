package com.huyhuynh.studycompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
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
        //simple
        SimpleButton()
        OutlinedButton(onClick = {}) {
            Text(text = "OutLine")
        }
        FilledTonalButton(onClick = { /*TODO*/ }) {//từ thư viện material3
            Text(text = "FilledTonalButton")
        }
        //elvevated
        ElevationButton()
        ElevatedButton(onClick = { /*TODO*/ }) { //phải thêm thư viên material3
            Text(text = "Elvated Button")
        }
        //text
        TextButton(onClick = { /*TODO*/ }) {
            Text("Text Button")
        }
        //modifier
        ClickComposable()
        Spacer(modifier = Modifier.height(10.dp))
        CombinedClickComposable()
        Spacer(modifier = Modifier.height(10.dp))
        PointerInput()
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

@Composable
fun ClickComposable(){
    Text(
        text = "Click Acction",
        modifier = Modifier.clickable {
            Log.d("Click","Click able Text")
        }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CombinedClickComposable(){
    Text(
        text = "CombinedClickComposable",
        modifier = Modifier.combinedClickable(
            onClick = {
                Log.d("CombinedClickComposable","onClick CombinedClickComposable")
            },
            onLongClick = {
                Log.d("CombinedClickComposable","onLongClick CombinedClickComposable")
            },
            onClickLabel = "Click"
        )
    )

}


@Composable
fun PointerInput(){
    Text(
        text = "Pointer",
        modifier = Modifier.pointerInput(Unit){
            detectTapGestures(
                onDoubleTap = {
                    Log.d("PointerInput","onDoubleTap PointerInput")
                },
                onTap = {
                    Log.d("PointerInput","onTap PointerInput")
                },
                onPress = {
                    Log.d("PointerInput","onPress PointerInput")
                }
            )
        }
    )
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreviewButtonActivity() {
    StudyComposeTheme {
        ButtonScreens()
    }
}