package com.example.sms_mui_compose.ui.theme.activity.components

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ImageGrid(plusButtonText:String,context: Context,imageCards: List<ImageCardData>, innerPadding: PaddingValues,target:Intent) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(innerPadding)
    ) {
        items(imageCards.size+1) { index -> // Use items(count)
            if(index == 0){
                PlusButtonImageCard( text = plusButtonText, onCardClick = { context.startActivity(target) }, modifier = Modifier.padding(16.dp))
                return@items
            }
            val considerIndex = index - 1
            val cardData = imageCards[considerIndex]
            ImageCardWithSVGSupport(imageUrl = cardData.imageUrl, text = cardData.text , onCardClick = { cardData.onCardClick(
                considerIndex
            ) }, modifier = Modifier.padding(16.dp))
        }
    }
}
