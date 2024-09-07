package com.example.sms_mui_compose

import android.content.Context
import android.widget.Toast.makeText
import com.example.sms_mui_compose.ui.theme.activity.components.ImageCardData
import com.example.sms_mui_compose.ui.theme.activity.onClick

class Constants {
    var BASE_URL = "http://35.154.109.58:8080/"
    var GET_CEOS = "CEOs"
    var GET_COMPANIES = "Companies"



    //http://35.154.109.58:8080/swagger-ui/index.html

}


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


fun getCardData(context: Context): List<ImageCardData> {
    var imageCards = listOf(
        ImageCardData(
            imageUrl = "https://static.toiimg.com/thumb/msid-97058029,width-1280,height-720,resizemode-4/97058029.jpg",
            text = "Card Description 1",
            onClick = {index-> onClick(context = context,index) }),
        ImageCardData(
            imageUrl = "https://static.toiimg.com/thumb/msid-97058029,width-1280,height-720,resizemode-4/97058029.jpg",
            text = "Card Description 1",
            onClick = {index-> onClick(context = context,index) }),
        ImageCardData(
            imageUrl = "https://static.toiimg.com/thumb/msid-97058029,width-1280,height-720,resizemode-4/97058029.jpg",
            text = "Card Description 1",
            onClick = {index-> onClick(context = context,index) }),
        ImageCardData(
            imageUrl = "https://static.toiimg.com/thumb/msid-97058029,width-1280,height-720,resizemode-4/97058029.jpg",
            text = "Card Description 1",
            onClick = {index-> onClick(context = context,index) }),
        ImageCardData(
            imageUrl = "https://static.toiimg.com/thumb/msid-97058029,width-1280,height-720,resizemode-4/97058029.jpg",
            text = "Card Description 1",
            onClick = {index-> onClick(context = context,index) }),
        ImageCardData(
            imageUrl = "https://static.toiimg.com/thumb/msid-97058029,width-1280,height-720,resizemode-4/97058029.jpg",
            text = "Card Description 1",
            onClick = {index-> onClick(context = context,index) }),
        ImageCardData(
            imageUrl = "https://static.toiimg.com/thumb/msid-97058029,width-1280,height-720,resizemode-4/97058029.jpg",
            text = "Card Description 1",
            onClick = {index-> onClick(context = context,index) }),
        ImageCardData(
            imageUrl = "https://static.toiimg.com/thumb/msid-97058029,width-1280,height-720,resizemode-4/97058029.jpg",
            text = "Card Description 1",
            onClick = {index-> onClick(context = context,index) }),
        ImageCardData(
            imageUrl = "https://static.toiimg.com/thumb/msid-97058029,width-1280,height-720,resizemode-4/97058029.jpg",
            text = "Card Description 1",
            onClick = {index-> onClick(context = context,index) }),
        ImageCardData(
            imageUrl = "https://static.toiimg.com/thumb/msid-97058029,width-1280,height-720,resizemode-4/97058029.jpg",
            text = "Card Description 1",
            onClick = {index-> onClick(context = context,index) }),
        ImageCardData(
            imageUrl = "https://static.toiimg.com/thumb/msid-97058029,width-1280,height-720,resizemode-4/97058029.jpg",
            text = "Card Description 1",
            onClick = {index-> onClick(context = context,index) }),
        ImageCardData(
            imageUrl = "https://static.toiimg.com/thumb/msid-97058029,width-1280,height-720,resizemode-4/97058029.jpg",
            text = "Card Description 1",
            onClick = {index-> onClick(context = context,index) }),
        ImageCardData(
            imageUrl = "https://static.toiimg.com/thumb/msid-97058029,width-1280,height-720,resizemode-4/97058029.jpg",
            text = "Card Description 1",
            onClick = {index-> onClick(context = context,index) }),
        ImageCardData(
            imageUrl = "https://static.toiimg.com/thumb/msid-97058029,width-1280,height-720,resizemode-4/97058029.jpg",
            text = "Card Description 1",
            onClick = {index-> onClick(context = context,index) }),
        ImageCardData(
            imageUrl = "https://static.toiimg.com/thumb/msid-97058029,width-1280,height-720,resizemode-4/97058029.jpg",
            text = "Card Description 1",
            onClick = {index-> onClick(context = context,index) }),
        ImageCardData(
            imageUrl = "https://static.toiimg.com/thumb/msid-97058029,width-1280,height-720,resizemode-4/97058029.jpg",
            text = "Card Description 1",
            onClick = {index-> onClick(context = context,index) }),
    )
    for( i in 0..<imageCards.size){
        imageCards[i].imageUrl = imageLinks[i]
    }
    return imageCards
}


private fun String.print() {
    print(this)
}

private fun String.Toast(c: Context) {
    makeText(c,this, android.widget.Toast.LENGTH_SHORT).show()
}
