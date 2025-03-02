package com.adrielmadrigal.androidnews.newsitem.view

import com.adrielmadrigal.androidnews.newsapi.data.model.NewsModel
import com.adrielmadrigal.androidnews.newsapi.services.NewsResult

sealed class ListNewsCardUiState {
    data object Idle: ListNewsCardUiState()
    data object Loading: ListNewsCardUiState()
    data class Success(val newsModel: NewsModel): ListNewsCardUiState()
    data object Error: ListNewsCardUiState()

}