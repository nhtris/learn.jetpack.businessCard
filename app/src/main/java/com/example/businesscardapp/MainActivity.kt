package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardAppTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    BusinessCardApp()
                }

            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    BusinessCardUi()
}

@Composable
fun BusinessCardUi(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        MainCenter(
            modifier = Modifier
                .weight(1f) // Trọng số chiếm toàn bộ không gian còn lại
                .fillMaxWidth()
        )

        Footer(
            Modifier
                .fillMaxWidth()
        )
    }
}

@Composable
fun MainCenter(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier // Chiều rộng đầy đủ
            .background(Color.LightGray)
            .fillMaxWidth().padding(10.dp).background(Color.Green), // Màu nền để dễ thấy
        contentAlignment = Alignment.Center // Căn giữa nội dung trong Box
    ) {
        Column {
            Text(text = "Jonie Nguyen", fontSize = 30.sp, textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().background(Color.Yellow))
            Text(
                text = "Dev Link Ting",
                textAlign = TextAlign.Center,
                modifier = Modifier.background(Color.Red).fillMaxWidth(),
                )
        }
    }
}

@Composable
fun Footer(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier // Chiều rộng đầy đủ
            .background(Color.DarkGray), // Màu nền để dễ thấy
        contentAlignment = Alignment.Center // Căn giữa nội dung trong Box
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ItemInfo(icon = Icons.Rounded.Call, text = "+84 981 626 857")
            ItemInfo(icon = Icons.Rounded.Share, text = "@facebook.com/triuet")
            ItemInfo(icon = Icons.Rounded.Email, text = "nhtri.dev@gmail.com")
        }

    }
}

@Composable
fun ItemInfo(icon: ImageVector, text: String, modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .background(Color.Green)
            .fillMaxWidth()
            .padding(horizontal = 64.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "",
            tint = Color(0xFF296047), // Đổi màu icon thành xanh
            modifier = Modifier.size(28.dp) // Kích thước 48dp)
        )
        Box(modifier = Modifier.padding(horizontal = 16.dp)) {
            Text(text = text)
        }

    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardAppTheme {
        BusinessCardApp()
    }
}