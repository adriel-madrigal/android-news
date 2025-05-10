package com.adrielmadrigal.androidnews.presentation.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NewsBottomBar() {
    BottomAppBar(
        modifier = Modifier.padding(0.dp),
        actions = {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconButton(onClick = { /*TODO*/} ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(Icons.Default.Home, contentDescription = "Home", modifier = Modifier.size(30.dp))
                        Text("Home", fontSize = 6.sp, style = MaterialTheme.typography.labelSmall)
                    }
                }
                IconButton(onClick = { /*TODO*/} ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(Icons.Default.PlayArrow, contentDescription = "Videos", modifier = Modifier.size(30.dp))
                        Text("Videos", fontSize = 6.sp, style = MaterialTheme.typography.labelSmall)
                    }
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(Icons.Default.Favorite, contentDescription = "Favorite", modifier = Modifier.size(30.dp))
                        Text("Favorite", fontSize = 6.sp, style = MaterialTheme.typography.labelSmall)
                    }
                }
                IconButton(onClick = { /*TODO*/} ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(Icons.Default.Menu, contentDescription = "Settings", modifier = Modifier.size(30.dp))
                        Text("Settings", fontSize = 6.sp, style = MaterialTheme.typography.labelSmall)
                    }
                }
            }


        }
    )
}

@Composable
@Preview
fun NewsBottomBarPreview() {
    NewsBottomBar()
}