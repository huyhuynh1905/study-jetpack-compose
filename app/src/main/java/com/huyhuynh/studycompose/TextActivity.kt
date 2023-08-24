package com.huyhuynh.studycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.huyhuynh.studycompose.ui.theme.Purple200
import com.huyhuynh.studycompose.ui.theme.Purple700
import com.huyhuynh.studycompose.ui.theme.StudyComposeTheme

class TextActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudyComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TextActivityScreen()
                }
            }
        }
    }
}

@Composable
fun TextActivityScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)) {
        SimpleText()
        Spacer(modifier = Modifier.height(10.dp))
        AnotatedText()
        Spacer(modifier = Modifier.height(10.dp))
        TextFillToResource()
    }
}

/**
 * Đây là text đơn giản với:
 * - stringResource: lấy string từ res/values/string.xml theo id.
 * - maxLines: số dòng tối đa.
 * - overflow: xử lý khi số lượng text dài hơn số dòng tối đa.
 */
@Composable
fun SimpleText(){
    Text(
        text = "Xin chào: ${stringResource(id = R.string.lorem_text)}",
        fontSize = 28.sp,
        color = Color.Blue,
        overflow = TextOverflow.Ellipsis,
        maxLines = 3
    )
}

/**
 * Đây là text có nhiều style
 * - buildAnnotatedString: chứa nhiều text append với nhiều style như bên dưới
 * - SpanStyle: là một textstyle dùng trong withStyle.
 *      - .copy(alpha = .5f): chỉnh độ đậm rõ của chữ
 */
@Composable
fun AnotatedText(){
    Text(text = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Blue.copy(alpha = .5f))){
            append("Huy ")
        }
        append("Huỳnh ")
        withStyle(style = SpanStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = Color.Green,
        )){
            append("Android ")
        }
        append("Xin chào ")
        addStyle(SpanStyle(color = Color.Red), "Hello World".length, this.length) //áp dụng style này theo vị trí từ xxx đến yyy
        append("Check")
        toAnnotatedString()
    })
}

/**
 * Text custom nhiều style:
 * - stringResource có nhiều tham số thì fill theo thứ tự sẵn trong string resource (Vd: %1$s %2$d ở dưới - s:string, d: số).
 * - shadow: Đổ bóng cho text.
 *      - color: color của bóng.
 *      - offset: x,y: vị trí bắt đầu đổ bóng.
 *      - blurRadius: độ rộng của bóng (càng lớn càng mờ)
 * - brush: brush trong TextStyle vẽ màu cho chữ
 *      - Brush.linearGradient: add list màu gradient, không giới hạn số màu.
 * - modifier: chỉnh nhiều thông số đến kích thước.
 * - textAlign: Chỉnh phân bố và bố cục chữ.
 */
@OptIn(ExperimentalTextApi::class)
@Composable
fun TextFillToResource(){
    val gradientColor = listOf(Cyan, Blue, Purple700)
    Text(
        text = stringResource(id = R.string.congratulate, "New Year", 2023),
        style = TextStyle(
            fontSize = 24.sp,
            shadow = Shadow(
                color = Color.Red,
                offset = Offset(5f,5f),
                blurRadius = 30f,
            ),
            brush = Brush.linearGradient(
                colors = gradientColor
            ),
        ),
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreviewText() {
    StudyComposeTheme {
        TextActivityScreen()
    }
}