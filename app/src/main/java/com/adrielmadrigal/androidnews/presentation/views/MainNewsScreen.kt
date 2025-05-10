package com.adrielmadrigal.androidnews.presentation.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainNewsScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = Modifier,
        topBar = { NewsTopBar() },
        bottomBar = { NewsBottomBar() }
    ) {
        paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            ListNewsCardScreen()
        }

    }
}

@Preview
@Composable
fun MainNewsScreenPreview() {
    MainNewsScreen(Modifier)
}