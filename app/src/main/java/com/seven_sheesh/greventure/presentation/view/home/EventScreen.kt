package com.seven_sheesh.greventure.presentation.view.home

import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.seven_sheesh.greventure.domain.model.EventType
import com.seven_sheesh.greventure.presentation.ui.design_system.GreventureScheme
import com.seven_sheesh.greventure.presentation.ui.navigation.nav_obj.HomeNavObj
import com.seven_sheesh.greventure.presentation.ui.widget.common.SnackBar
import com.seven_sheesh.greventure.presentation.ui.widget.home.EventCard
import com.seven_sheesh.greventure.presentation.viewmodel.NavbarViewModel
import com.seven_sheesh.greventure.ui.viewmodel.BubbleViewModel

@Composable
@Preview
fun EventScreen(
    homeNavController: NavController = rememberNavController(),
    navbarViewModel: NavbarViewModel = hiltViewModel(),
){
    navbarViewModel.setPageState(0)
    val bubbleViewModel = hiltViewModel<BubbleViewModel>()
    val bubbleList = bubbleViewModel.bubbleListState.collectAsState()
    val selectedCategory = remember { mutableStateOf(EventType.Lingkungan) }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .safeDrawingPadding(),
        contentAlignment = Alignment.Center) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            item {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .background(GreventureScheme.Primary.color),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .fillMaxSize(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Icon(imageVector = Icons.Default.ArrowBackIosNew, contentDescription = "Arrow Back", modifier = Modifier.clickable {
                            homeNavController.navigate(HomeNavObj.HomeScreen.route)
                        }, tint = GreventureScheme.White.color)
                        Column {
                            Text(text = "Event", fontWeight = FontWeight.SemiBold, fontSize = 22.sp, color = GreventureScheme.White.color)
                        }
                        Spacer(modifier = Modifier.padding(horizontal = 8.dp))
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)){
                    SnackBar(onClick = {
                        selectedCategory.value = it
                    })
                }
            }

            items(bubbleList.value.second.filter { it.eventType == selectedCategory.value }) {
                Spacer(modifier = Modifier.height(16.dp))
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)) {
                        EventCard(homeNavController = homeNavController, bubble = it)
                }
            }
        }
    }
}