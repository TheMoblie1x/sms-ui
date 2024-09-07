package com.example.sms_mui_compose.ui.theme.activity.components

// Data class to hold image card information
data class ImageCardData(
    var imageUrl: String,
    val text: String,
    val onCardClick: () -> Unit
)