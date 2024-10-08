package com.seven_sheesh.greventure.presentation.ui.widget.maps

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seven_sheesh.greventure.presentation.ui.design_system.GreventureScheme
import com.seven_sheesh.greventure.presentation.ui.widget.common.Accordion

@Composable
fun FAQSection() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Spacer(modifier = Modifier.height(32.dp))
        HorizontalDivider(color = GreventureScheme.SoftGray.color, thickness = 1.dp)
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "FAQ",
            color = GreventureScheme.Black.color,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(12.dp))
        Accordion()
        Spacer(modifier = Modifier.height(32.dp))

    }
}