package com.example.sms_mui_compose.ui.theme.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.sms_mui_compose.ui.theme.SmsmuicomposeTheme
import com.example.sms_mui_compose.ui.theme.activity.components.ImageCardData
import com.example.sms_mui_compose.ui.theme.activity.components.ImageGrid

class CompaniesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SmsmuicomposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ImageGrid(getCardData())
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    SmsmuicomposeTheme {
        ImageGrid(getCardData())
    }
}

fun getCardData(): List<ImageCardData> {
    val imageCards = listOf(
        ImageCardData(
            imageUrl = "https://static.toiimg.com/thumb/msid-97058029,width-1280,height-720,resizemode-4/97058029.jpg",
            text = "Card Description 1",
            onCardClick = { /* Handle click */ }),
        ImageCardData(
            imageUrl = "https://static.toiimg.com/thumb/msid-97058029,width-1280,height-720,resizemode-4/97058029.jpg",
            text = "Card Description 1",
            onCardClick = { /* Handle click */ }),
        ImageCardData(
            imageUrl = "https://static.toiimg.com/thumb/msid-97058029,width-1280,height-720,resizemode-4/97058029.jpg",
            text = "Card Description 1",
            onCardClick = { /* Handle click */ }),
        ImageCardData(
            imageUrl = "https://static.toiimg.com/thumb/msid-97058029,width-1280,height-720,resizemode-4/97058029.jpg",
            text = "Card Description 1",
            onCardClick = { /* Handle click */ }),
        ImageCardData(
            imageUrl = "https://static.toiimg.com/thumb/msid-97058029,width-1280,height-720,resizemode-4/97058029.jpg",
            text = "Card Description 1",
            onCardClick = { /* Handle click */ }),
        ImageCardData(
            imageUrl = "https://static.toiimg.com/thumb/msid-97058029,width-1280,height-720,resizemode-4/97058029.jpg",
            text = "Card Description 1",
            onCardClick = { /* Handle click */ }),
        ImageCardData(
            imageUrl = "https://static.toiimg.com/thumb/msid-97058029,width-1280,height-720,resizemode-4/97058029.jpg",
            text = "Card Description 1",
            onCardClick = { /* Handle click */ }),
        ImageCardData(
            imageUrl = "https://static.toiimg.com/thumb/msid-97058029,width-1280,height-720,resizemode-4/97058029.jpg",
            text = "Card Description 1",
            onCardClick = { /* Handle click */ }),
        ImageCardData(
            imageUrl = "https://static.toiimg.com/thumb/msid-97058029,width-1280,height-720,resizemode-4/97058029.jpg",
            text = "Card Description 1",
            onCardClick = { /* Handle click */ }),
        ImageCardData(
            imageUrl = "https://static.toiimg.com/thumb/msid-97058029,width-1280,height-720,resizemode-4/97058029.jpg",
            text = "Card Description 1",
            onCardClick = { /* Handle click */ }),
        ImageCardData(
            imageUrl = "https://static.toiimg.com/thumb/msid-97058029,width-1280,height-720,resizemode-4/97058029.jpg",
            text = "Card Description 1",
            onCardClick = { /* Handle click */ }),
        ImageCardData(
            imageUrl = "https://static.toiimg.com/thumb/msid-97058029,width-1280,height-720,resizemode-4/97058029.jpg",
            text = "Card Description 1",
            onCardClick = { /* Handle click */ }),
        ImageCardData(
            imageUrl = "https://static.toiimg.com/thumb/msid-97058029,width-1280,height-720,resizemode-4/97058029.jpg",
            text = "Card Description 1",
            onCardClick = { /* Handle click */ }),
        ImageCardData(
            imageUrl = "https://static.toiimg.com/thumb/msid-97058029,width-1280,height-720,resizemode-4/97058029.jpg",
            text = "Card Description 1",
            onCardClick = { /* Handle click */ }),
        ImageCardData(
            imageUrl = "https://static.toiimg.com/thumb/msid-97058029,width-1280,height-720,resizemode-4/97058029.jpg",
            text = "Card Description 1",
            onCardClick = { /* Handle click */ }),
        ImageCardData(
            imageUrl = "https://static.toiimg.com/thumb/msid-97058029,width-1280,height-720,resizemode-4/97058029.jpg",
            text = "Card Description 1",
            onCardClick = { /* Handle click */ }),
        // Add more ImageCardData objects as needed
    )
    return imageCards
}