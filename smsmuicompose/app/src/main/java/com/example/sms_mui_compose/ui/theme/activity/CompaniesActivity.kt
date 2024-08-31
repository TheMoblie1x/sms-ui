package com.example.sms_mui_compose.ui.theme.activity

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast.makeText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.sms_mui_compose.network.GetEntityList
import com.example.sms_mui_compose.network.company.Company
import com.example.sms_mui_compose.ui.theme.SmsmuicomposeTheme
import com.example.sms_mui_compose.ui.theme.activity.components.ImageCardData
import com.example.sms_mui_compose.ui.theme.activity.components.ImageGrid
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CompaniesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
         var allCompaniesList: List<Company>? = null

        lifecycleScope.launch {
            val result = withContext(Dispatchers.IO){
                GetEntityList().getAllCompaniesList()
            }
            setContent {
                SmsmuicomposeTheme {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        ImageGrid(getCard(result))
                    }
                }
            }
        }


    }
}

private fun String.print() {
    print(this)
}

private fun String.Toast(c: Context) {
    makeText(c,this, android.widget.Toast.LENGTH_SHORT).show()
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    SmsmuicomposeTheme {
        ImageGrid(getCardData())
    }
}
fun getCard(result:List<Company>):List<ImageCardData>{
    var list = mutableListOf(ImageCardData(
        imageUrl = "https://static.toiimg.com/thumb/msid-97058029,width-1280,height-720,resizemode-4/97058029.jpg",
        text = "Card Description 1",
        onCardClick = { /* Handle click */ }))
    for( i in result){
        val imageCardData = ImageCardData(
            imageUrl = "https://static.toiimg.com/thumb/msid-97058029,width-1280,height-720,resizemode-4/97058029.jpg",
            text = i.name,
            onCardClick = {
                Log.d("Click", "getCard() called, Clicked ${i.name}")
            })
        list.add(imageCardData)
    }
    return list
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