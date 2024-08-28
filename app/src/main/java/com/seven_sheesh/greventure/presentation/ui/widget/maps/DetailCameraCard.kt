package com.seven_sheesh.greventure.presentation.ui.widget.maps

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.seven_sheesh.greventure.domain.model.BubbleSocialMedia
import com.seven_sheesh.greventure.presentation.ui.design_system.GreventureScheme
import com.seven_sheesh.greventure.presentation.ui.navigation.nav_obj.HomeNavObj

@Composable
fun CameraCard(
    homeNavController: NavController,
    currentBubbleSocialMedia: State<Pair<String, List<BubbleSocialMedia>>>
) {
    Spacer(modifier = Modifier.height(12.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Card(
            modifier = Modifier.size(48.dp),
            shape = RoundedCornerShape(50),
            colors = CardDefaults.cardColors(GreventureScheme.White.color),
            border = BorderStroke(2.dp, GreventureScheme.PrimaryVariant2.color)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        homeNavController.navigate(HomeNavObj.NotificationScreen.route)
                    },
                contentAlignment = Alignment.Center
            ) {
                Icon(imageVector = Icons.Default.CameraAlt, contentDescription = "Camera", tint = GreventureScheme.Primary.color)
            }
        }
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text(text = currentBubbleSocialMedia.value.second.firstOrNull()?.type.toString() + ": " +
                currentBubbleSocialMedia.value.second.firstOrNull()?.content.toString(), color = GreventureScheme.Black.color)
        }
    }
}