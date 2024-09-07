package com.example.sms_mui_compose.ui.theme.activity

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast.makeText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.example.sms_mui_compose.network.GetEntityList
import com.example.sms_mui_compose.network.company.Company
import com.example.sms_mui_compose.ui.theme.SmsmuicomposeTheme
import com.example.sms_mui_compose.ui.theme.activity.components.ImageCardData
import com.example.sms_mui_compose.ui.theme.activity.components.ImageGrid
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

val imageLinks =arrayOf(
    "https://www.logo.wine/a/logo/Google/Google-Logo.wine.svg", // Google (direct JPG not available; SVG provided)
    "https://www.logo.wine/a/logo/Apple/Apple-Logo.wine.svg", // Apple (direct JPG not available; SVG provided)
    "https://www.logo.wine/a/logo/Intel/Intel-Logo.wine.svg", // Intel (direct JPG not available; SVG provided)
    "https://www.logo.wine/a/logo/Microsoft/Microsoft-Logo.wine.svg", // Microsoft (direct JPG not available; SVG provided)
    "https://www.logo.wine/a/logo/Adobe/Adobe-Logo.wine.svg", // Adobe (direct JPG not available; SVG provided)
    "https://www.logo.wine/a/logo/Android/Android-Logo.wine.svg", // Android (direct JPG not available; SVG provided)
    "https://www.logo.wine/a/logo/WhatsApp/WhatsApp-Logo.wine.svg", // WhatsApp (direct JPG not available; SVG provided)
    "https://www.logo.wine/a/logo/Slack/Slack-Logo.wine.svg", // Slack (direct JPG not available; SVG provided)
    "https://www.logo.wine/a/logo/Dropbox/Dropbox-Logo.wine.svg", // Dropbox (direct JPG not available; SVG provided)
    "https://www.logo.wine/a/logo/Twitter/Twitter-Logo.wine.svg", // Twitter (direct JPG not available; SVG provided)
    "https://www.logo.wine/a/logo/Spotify/Spotify-Logo.wine.svg", // Spotify (direct JPG not available; SVG provided)
    "https://www.logo.wine/a/logo/Facebook/Facebook-Logo.wine.svg", // Facebook (direct JPG not available; SVG provided)
    "https://www.logo.wine/a/logo/Samsung/Samsung-Logo.wine.svg", // Samsung (direct JPG not available; SVG provided)
    "https://www.logo.wine/a/logo/Netflix/Netflix-Logo.wine.svg", // Netflix (direct JPG not available; SVG provided)
    "https://www.logo.wine/a/logo/Google/Google-Logo.wine.svg", // Google (direct JPG not available; SVG provided)
    "https://www.logo.wine/a/logo/Apple/Apple-Logo.wine.svg", // Apple (direct JPG not available; SVG provided)
    "https://www.logo.wine/a/logo/Intel/Intel-Logo.wine.svg", // Intel (direct JPG not available; SVG provided)
    "https://www.logo.wine/a/logo/Microsoft/Microsoft-Logo.wine.svg", // Microsoft (direct JPG not available; SVG provided)
    "https://www.logo.wine/a/logo/Adobe/Adobe-Logo.wine.svg", // Adobe (direct JPG not available; SVG provided)
    "https://www.logo.wine/a/logo/Android/Android-Logo.wine.svg", // Android (direct JPG not available; SVG provided)
    "https://www.logo.wine/a/logo/WhatsApp/WhatsApp-Logo.wine.svg", // WhatsApp (direct JPG not available; SVG provided)
    "https://www.logo.wine/a/logo/Slack/Slack-Logo.wine.svg", // Slack (direct JPG not available; SVG provided)
    "https://www.logo.wine/a/logo/Dropbox/Dropbox-Logo.wine.svg", // Dropbox (direct JPG not available; SVG provided)
    "https://www.logo.wine/a/logo/Twitter/Twitter-Logo.wine.svg", // Twitter (direct JPG not available; SVG provided)
    "https://www.logo.wine/a/logo/Spotify/Spotify-Logo.wine.svg", // Spotify (direct JPG not available; SVG provided)
    "https://www.logo.wine/a/logo/Facebook/Facebook-Logo.wine.svg", // Facebook (direct JPG not available; SVG provided)
    "https://www.logo.wine/a/logo/Samsung/Samsung-Logo.wine.svg", // Samsung (direct JPG not available; SVG provided)
    "https://www.logo.wine/a/logo/Netflix/Netflix-Logo.wine.svg", // Netflix (direct JPG not available; SVG provided)
    "https://www.logo.wine/a/logo/LinkedIn/LinkedIn-Logo.wine.svg", // LinkedIn (direct JPG not available; SVG provided)
    "https://www.logo.wine/a/logo/Tesla/Tesla-Logo.wine.svg", // Tesla (direct JPG not available; SVG provided)
    "https://www.logo.wine/a/logo/Oracle/Oracle-Logo.wine.svg", // Oracle (direct JPG not available; SVG provided)
    "https://www.logo.wine/a/logo/Amazon/Amazon-Logo.wine.svg", // Amazon (direct JPG not available; SVG provided)
    "https://www.logo.wine/a/logo/Sony/Sony-Logo.wine.svg", // Sony (direct JPG not available; SVG provided)
    "https://www.logo.wine/a/logo/NVIDIA/NVIDIA-Logo.wine.svg", // NVIDIA (direct JPG not available; SVG provided)
    "https://www.logo.wine/a/logo/PayPal/PayPal-Logo.wine.svg", // PayPal (direct JPG not available; SVG provided)
    "https://www.logo.wine/a/logo/IBM/IBM-Logo.wine.svg", // IBM (direct JPG not available; SVG provided)
    "https://www.logo.wine/a/logo/Stripe/Stripe-Logo.wine.svg", // Stripe (direct JPG not available; SVG provided)
    "https://www.logo.wine/a/logo/Red_Hat/Red_Hat-Logo.wine.svg", // Red Hat (direct JPG not available; SVG provided)
    "https://www.logo.wine/a/logo/HP/HP-Logo.wine.svg", // HP (direct JPG not available; SVG provided)
    "https://www.logo.wine/a/logo/Square/Square-Logo.wine.svg", // Square (direct JPG not available; SVG provided)
    "https://www.logo.wine/a/logo/Alibaba/Alibaba-Logo.wine.svg", // Alibaba (direct JPG not available; SVG provided)
    "https://www.logo.wine/a/logo/Ubuntu/Ubuntu-Logo.wine.svg", // Ubuntu (direct JPG not available; SVG provided)
    "https://www.logo.wine/a/logo/Qualcomm/Qualcomm-Logo.wine.svg", // Qualcomm (direct JPG not available; SVG provided)
    "https://www.logo.wine/a/logo/VMware/VMware-Logo.wine.svg", // VMware (direct JPG not available; SVG provided)
    "https://www.logo.wine/a/logo/Salesforce/Salesforce-Logo.wine.svg" // Salesforce (direct JPG not available; SVG provided)
)


class CompaniesActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
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
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = { TopBar("Companies",{finish()}) }
                        ) { innerPadding ->
                        ImageGrid(getCard(result), innerPadding)
                        //ImageGrid(getCardData())//Gets card with hardcoded data
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
        ImageGrid(getCardData(), PaddingValues(12.dp,12.dp))
    }
}
fun getCard(result:List<Company>):List<ImageCardData>{
    var list = mutableListOf<ImageCardData>()
    for( i in result){
        val imageCardData = ImageCardData(
            imageUrl = "https://static.toiimg.com/thumb/msid-97058029,width-1280,height-720,resizemode-4/97058029.jpg",
            text = i.name,
            onCardClick = {
                Log.d("Click", "getCard() called, Clicked ${i.name}")
            })
        list.add(imageCardData)
    }

    for( i in 0..<list.size){
        list[i].imageUrl = imageLinks[i]
    }

    return list
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(text:String,clickEvent:()->Unit){
    return TopAppBar(
        title = { Text(text) },
        navigationIcon = {
            IconButton(onClick = { /* Handle back button click */clickEvent() }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
            }
        }
    )
}

fun getCardData(): List<ImageCardData> {
    var imageCards = listOf(
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

    for( i in 0..<imageCards.size){
        imageCards[i].imageUrl = imageLinks[i]
    }

    return imageCards
}