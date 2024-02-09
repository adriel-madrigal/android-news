package com.adrielmadrigal.androidnews.newsitem.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.adrielmadrigal.androidnews.newsapi.model.app.NewsModelApp
import com.adrielmadrigal.androidnews.newsapi.services.NewsResult
import com.adrielmadrigal.androidnews.newsitem.viewmodel.ListNewsCardViewModel
import com.adrielmadrigal.androidnews.util.toComposeState

@Composable
fun ListNewsCardView(viewModel: ListNewsCardViewModel = viewModel()) {
    val newsResult by viewModel.newsResult.toComposeState()
    when (newsResult) {
        is NewsResult.Success -> {
            val newsResponse: NewsModelApp = (newsResult as NewsResult.Success).newsResponse
            Column() {
                newsResponse.articles.forEach { article->
                    NewsCardSummaryView(article = article)
                }
            }
        }
        is NewsResult.Error -> {
            val errorMessage: String = (newsResult as NewsResult.Error).errorMessage

            println(errorMessage)
        }
        is NewsResult.Loading -> {
        }

        else -> {
            Text(text = "Else condition")
        }
    }

    DisposableEffect(Unit) {
        onDispose {  }
    }
}

@Composable
@Preview
fun ListNewsCardView_Preview() {
    ListNewsCardView()
}