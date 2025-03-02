package com.adrielmadrigal.androidnews.newsitem.view

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.hilt.navigation.compose.hiltViewModel
import com.adrielmadrigal.androidnews.newsapi.data.model.NewsModel
import com.adrielmadrigal.androidnews.newsitem.viewmodel.ListNewsCardViewModel

@Composable
fun ListNewsCardScreen(
    modifier: Modifier = Modifier,
    viewModel: ListNewsCardViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsState()
    ListNewsCardContent(uiState = uiState)
}

@Composable
fun ListNewsCardContent(
    uiState: ListNewsCardUiState,
    modifier: Modifier = Modifier,
) {

    when (uiState) {
        ListNewsCardUiState.Idle -> {
            Box(
                modifier = Modifier.fillMaxSize()
            )
            Text(text = "Idle")
        }
        ListNewsCardUiState.Loading -> {
            Text(text = "Loading")
        }
        ListNewsCardUiState.Error -> {
            Text(text = "Error")
            Text(text = "Error couldn't find the news")
        }
        is ListNewsCardUiState.Success -> {
            val newsModel: NewsModel = uiState.newsModel
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                newsModel.articles.forEach { article->
                    NewsCardSummaryView(article = article)
                }
            }
        }
    }
}

@Preview(
    name = "Day theme",
    showBackground = true,
    showSystemUi = true,
    uiMode = UI_MODE_NIGHT_NO
)
@Preview(
    name = "Night theme",
    showBackground = true,
    showSystemUi = true,
    uiMode = UI_MODE_NIGHT_YES

)
annotation class DayNightPreviews

@DayNightPreviews
@Composable
fun ListNewsCardContent_Loading_Preview(
    @PreviewParameter(ListNewsCardUiStatePreviewParameterProvider::class) listNewsCardUiState: ListNewsCardUiState
) {
    ListNewsCardContent(listNewsCardUiState)
}

