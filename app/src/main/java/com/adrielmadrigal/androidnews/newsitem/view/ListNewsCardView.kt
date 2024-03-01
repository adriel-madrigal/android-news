package com.adrielmadrigal.androidnews.newsitem.view


import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.adrielmadrigal.androidnews.newsapi.data.model.NewsModel
import com.adrielmadrigal.androidnews.newsapi.services.NewsResult
import com.adrielmadrigal.androidnews.newsitem.viewmodel.ListNewsCardViewModel

@Composable
fun ListNewsCardView(viewModel: ListNewsCardViewModel = viewModel()) {

    val newsResult by viewModel.newsResult.observeAsState()
    when (val result = newsResult) {
        is NewsResult.Success -> {
            Text(text = "Success")
            val newsResponse: NewsModel = result.newsResponse
            Column() {
                newsResponse.articles.forEach { article->
                    NewsCardSummaryView(article = article)
                }
            }
        }
        is NewsResult.Error -> {
            val errorMessage: String = result.errorMessage
            Text(text = "Error is $errorMessage")
        }
        is NewsResult.Loading -> {
            Text(text = "Loading")
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