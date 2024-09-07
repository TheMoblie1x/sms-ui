package com.example.sms_mui_compose.ui.theme.activity.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ImageGrid(imageCards: List<ImageCardData>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(8.dp)
    ) {
        items(imageCards.size) { index -> // Use items(count)
            val cardData = imageCards[index]
     //       ImageCardWithJPGSupport(imageUrl = cardData.imageUrl, text = cardData.text , onCardClick = { cardData.onCardClick }, modifier = Modifier.padding(16.dp))
            ImageCardWithSVGSupport(imageUrl = cardData.imageUrl, text = cardData.text , onCardClick = { cardData.onCardClick }, modifier = Modifier.padding(16.dp))
        }
    }
}
