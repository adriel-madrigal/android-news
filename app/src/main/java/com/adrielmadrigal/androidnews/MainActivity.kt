package com.adrielmadrigal.androidnews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.adrielmadrigal.androidnews.presentation.views.ListNewsCardScreen
import com.adrielmadrigal.androidnews.presentation.views.MainNewsScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainNewsScreen()
//            ListNewsCardScreen()
        }
    }
}
