package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
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
    BusinessCardUi(
        name = stringResource(id = R.string.userName),
        title = stringResource(id = R.string.userTitle)
    )
}

@Composable
fun BusinessCardUi(name: String, title: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .fillMaxSize()
        .background(Color(0xFFDAE5DB))) {
        MainCenter(
            name = name,
            title = title,
            modifier = Modifier
                .weight(1f) // Trọng số chiếm toàn bộ không gian còn lại
                .fillMaxWidth()
        )

        Footer(
            phone = stringResource(id = R.string.userPhone),
            socialMedia = stringResource(id = R.string.userSocialMedia),
            email = stringResource(id = R.string.userEmail),
            modifier = Modifier.padding(bottom = 50.dp)
        )
    }
}

@Composable
fun MainCenter(name: String, title: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier, // Chiều rộng đầy đủ
        contentAlignment = Alignment.Center // Căn giữa nội dung trong Box
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(modifier = Modifier.padding(bottom = 20.dp)) {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color(0xFF182C35))
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.android_logo),
                        contentDescription = "Android Logo",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }

            Text(
                text = name,
                fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold,
//                textAlign = TextAlign.Center,
                modifier = Modifier
//                    .fillMaxWidth()
//                    .background(Color.Yellow)
                    .padding(bottom = 10.dp)
            )
            Text(
                text = title,
                fontWeight = FontWeight.Medium,
//                textAlign = TextAlign.Center,
                modifier = Modifier
//                    .background(Color.Red)
//                    .fillMaxWidth(),
            )
        }
    }
}

@Composable
fun Footer(
    phone: String,
    socialMedia: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ItemInfo(icon = Icons.Rounded.Call, text = phone)
            ItemInfo(icon = Icons.Rounded.Share, text = socialMedia)
            ItemInfo(icon = Icons.Rounded.Email, text = email)
        }
    }



}

@Composable
fun ItemInfo(icon: ImageVector, text: String, modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
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