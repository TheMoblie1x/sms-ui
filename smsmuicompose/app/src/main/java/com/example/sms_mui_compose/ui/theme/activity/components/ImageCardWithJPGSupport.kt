package com.example.sms_mui_compose.ui.theme.activity.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest

@Composable
fun ImageCardWithJPGSupport(
    imageUrl: String,
    text: String,
    onCardClick: () -> Unit, // Custom click event handler
    modifier :Modifier
) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .clickable { onCardClick() }, // Add click listener
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = imageUrl,
                contentDescription = "Card Image",
                modifier = Modifier.size(150.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = text)
        }
    }
}




@Composable
fun ImageCardWithSVGSupport(
    imageUrl: String,
    text: String,
    onCardClick: () -> Unit, // Custom click event handler
    modifier :Modifier
) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .clickable { onCardClick() }, // Add click listener
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(imageUrl)
                    .decoderFactory(SvgDecoder.Factory()) // Use SVG decoder
                    .build(),
                contentDescription = "Card Image",
                modifier = Modifier.size(150.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = text)
        }
    }
}

