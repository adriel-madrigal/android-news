package com.adrielmadrigal.androidnews.newsitem.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.adrielmadrigal.androidnews.newsapi.NewsResponse
import com.adrielmadrigal.androidnews.newsapi.NewsResult
import com.adrielmadrigal.androidnews.newsitem.viewmodel.ListNewsCardViewModel
import com.adrielmadrigal.androidnews.util.toComposeState

@Composable
fun ListNewsCardView(viewModel: ListNewsCardViewModel = viewModel()) {
//    val newsResult by viewModel.newsResult.toComposeState()
//
//    when (newsResult) {
//        is NewsResult.Success -> {
//            val newsResponse: NewsResponse = (newsResult as NewsResult.Success).newsResponse
//            Column() {
//                newsResponse.articles.take(10).forEach { article->
//                    NewsCardSummaryView(article = article)
//                }
//            }
//            println("Success")
//        }
//        is NewsResult.Error -> {
//            val errorMessage: String = (newsResult as NewsResult.Error).errorMessage
//            println("Error")
//        }
//        is NewsResult.Loading -> {
//        }
//
//        else -> {
//            println("Error")
//            Text(text = "Else condition")
//        }
//    }
//
//    DisposableEffect(Unit) {
////        viewModel.fetchNews()
//        onDispose {  }
//    }
}

@Composable
@Preview
fun ListNewsCardView_Preview() {
    ListNewsCardView()
}