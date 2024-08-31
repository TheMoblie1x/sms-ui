package com.example.sms_mui_compose.ui.theme.activity.components

// Data class to hold image card information
data class ImageCardData(
    val imageUrl: String,
    val text: String,
    val onCardClick: () -> Unit
)