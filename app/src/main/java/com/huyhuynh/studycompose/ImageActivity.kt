package com.huyhuynh.studycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.huyhuynh.studycompose.ui.theme.StudyComposeTheme

class ImageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudyComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ImageActivityScreen()
                }
            }
        }
    }
}


@Composable
fun ImageActivityScreen(){
    val rainbowColorsBrush = remember {
        Brush.sweepGradient(
            listOf(
                Color(0xFF9575CD),
                Color(0xFFBA68C8),
                Color(0xFFE57373),
                Color(0xFFFFB74D),
                Color(0xFFFFF176),
                Color(0xFFAED581),
                Color(0xFF4DD0E1),
                Color(0xFF9575CD)
            )
        )
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
        .padding(10.dp)) {
        ImagePainter(
            modifier = Modifier.size(width = 250.dp, height = 150.dp)
                .border(
                    border = BorderStroke(5.dp, rainbowColorsBrush)
                )
                .graphicsLayer {
                    this.alpha = .4f
                }
        )
        IconSimple()
        ImagePainter(
            modifier = Modifier
                .size(50.dp)
                .clip(shape = CircleShape),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(15.dp))
        ImagePainter(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .height(150.dp)
                .clip(shape = RoundedCornerShape(15.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(10.dp))
        InternetImage()
        GraphicsImage()
    }
}

@Composable
fun ImagePainter(modifier: Modifier = Modifier, contentScale: ContentScale = ContentScale.Fit){
    Image(
        painter = painterResource(id = R.drawable.banner),
        contentDescription = "",
        modifier = modifier,
        contentScale = contentScale
    )
}

@Composable
fun IconSimple(){
    Icon(
        Icons.Rounded.Call,
        contentDescription = "",
        tint = Color.Red
    )
}

@Composable
fun InternetImage(){
    AsyncImage(
        model = "https://inkythuatso.com/uploads/thumbnails/800/2022/06/hinh-anh-dep-ve-du-lich-viet-nam-cho-dien-thoai-1-inkythuatso-08-14-13-02.jpg",
        contentDescription = "",
        placeholder = painterResource(id = R.drawable.ic_launcher_background),
        error = painterResource(id = R.drawable.banner)
    )
}

@Composable
fun GraphicsImage(){
    Canvas(modifier = Modifier.size(width = 400.dp, height = 500.dp)) {
        rotate(degrees = 45F) {
            drawRect(
                color = Color.Gray,
                topLeft = Offset(x = size.width / 3F, y = size.height / 3F),
                size = size / 3F
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreviewImageActivity() {
    StudyComposeTheme {
        ImageActivityScreen()
    }
}