package com.adrielmadrigal.androidnews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.adrielmadrigal.androidnews.newsapi.NewsResponse
import com.adrielmadrigal.androidnews.newsitem.view.ListNewsCardView
import com.adrielmadrigal.androidnews.newsitem.view.NewsCardSummaryView
import com.adrielmadrigal.androidnews.newsitem.view.NewsCardView
import com.adrielmadrigal.androidnews.ui.theme.AndroidNewsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListNewsCardView()
        }
    }
}