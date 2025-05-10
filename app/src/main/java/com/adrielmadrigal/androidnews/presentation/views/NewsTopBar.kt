package com.adrielmadrigal.androidnews.presentation.views

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsTopBar() {
    TopAppBar(
        title = { Text("News") },
        navigationIcon = {
//            IconButton(onClick = { /* Handle navigation icon click */ }) {
//                Icon(Icons.Default.Menu, contentDescription = "Menu")
//            }
        },
        actions = {
            IconButton(onClick = { /* Handle action icon click */ }) {
                Icon(Icons.Default.Search, contentDescription = "Action")
            }
        }
    )
}

@Preview
@Composable
fun NewsTopBarPreview() {
    NewsTopBar()
}