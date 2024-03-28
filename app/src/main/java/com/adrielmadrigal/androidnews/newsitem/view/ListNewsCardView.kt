package com.adrielmadrigal.androidnews.newsitem.view


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.adrielmadrigal.androidnews.newsapi.data.model.NewsModel
import com.adrielmadrigal.androidnews.newsapi.services.NewsResult
import com.adrielmadrigal.androidnews.newsitem.usecase.impl.PreviewFetchNewsArticleUseCaseImpl
import com.adrielmadrigal.androidnews.newsitem.viewmodel.ListNewsCardViewModel

@Composable
fun ListNewsCardView(viewModel: ListNewsCardViewModel = viewModel()) {

    val newsResult by viewModel.newsResult.observeAsState()
    when (val result = newsResult) {
        is NewsResult.Success -> {

            val newsResponse: NewsModel = result.newsResponse
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
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
fun ListNewsCardViewSuccess_Preview() {
    val listNewsCardViewModel = ListNewsCardViewModel(PreviewFetchNewsArticleUseCaseImpl())
    ListNewsCardView(listNewsCardViewModel)
}

@Composable
@Preview
fun ListNewsCardViewLoading_Preview() {
    ListNewsCardView()
}

@Composable
@Preview
fun ListNewsCardViewError_Preview() {
    ListNewsCardView()
}