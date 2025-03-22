package com.adrielmadrigal.androidnews.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adrielmadrigal.androidnews.domain.models.FullNews
import com.adrielmadrigal.androidnews.domain.models.NewsArticle
import com.adrielmadrigal.androidnews.domain.usecases.FetchNewsArticlesUseCase
import com.adrielmadrigal.androidnews.presentation.uistates.ListNewsCardUiState
import com.adrielmadrigal.androidnews.services.NewsResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListNewsCardViewModel @Inject constructor(
    private val fetchNewsArticlesUseCase: FetchNewsArticlesUseCase
): ViewModel() {

    private val mutableUiState = MutableStateFlow<ListNewsCardUiState>(ListNewsCardUiState.Idle)
    val uiState = mutableUiState.asStateFlow()

    init {
        fetchNews()
    }

    private fun fetchNews() {

        viewModelScope.launch {
            mutableUiState.update {
                ListNewsCardUiState.Loading
            }
            when (val newsResult = fetchNewsArticlesUseCase()) {
                is NewsResult.Success -> handleSuccess(newsResult.newsResponse)
                is NewsResult.Error -> handleError(newsResult.errorMessage)
                NewsResult.Loading -> {}
            }

        }
    }

    private fun handleSuccess(fullNews: FullNews) {
        val filteredNewsArticles = fullNews.articles.filter { newsArticle: NewsArticle ->
            newsArticle.title != "[Removed]"
        }

        mutableUiState.update {
            val filteredNews = fullNews.copy(articles = filteredNewsArticles)
            ListNewsCardUiState.Success(filteredNews)
        }
    }

    private fun handleError(errorMessage: String) {
        mutableUiState.update {
            ListNewsCardUiState.Error(errorMessage)
        }
    }
}