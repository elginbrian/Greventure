package com.seven_sheesh.greventure.presentation.ui.widget.maps

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.seven_sheesh.greventure.domain.model.Bubble
import com.seven_sheesh.greventure.domain.model.BubblePhoto
import com.seven_sheesh.greventure.domain.model.EventColor
import com.seven_sheesh.greventure.domain.model.EventType
import com.seven_sheesh.greventure.presentation.ui.design_system.GreventureScheme

@Composable
fun PictureCard(
    currentBubblePhoto: State<Pair<String, List<BubblePhoto>>>,
    currentBubble: State<Pair<String, Bubble?>>
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(if(currentBubble.value.second?.eventType != null) EventColor(
            currentBubble.value.second?.eventType!!
        ) else GreventureScheme.Success.color)
    ) {
        AsyncImage(model = currentBubblePhoto.value.second.firstOrNull()?.url, contentDescription = "photo", modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
    }
}