package com.adrielmadrigal.androidnews.newsapi.services

import com.adrielmadrigal.androidnews.newsapi.model.app.NewsModelApp

sealed class NewsResult {
    data class Success(val newsResponse: NewsModelApp): NewsResult()
    data class Error(val errorMessage: String): NewsResult()
//    data class Loading(val newsResponse: NewsResponse): NewsResult()
    object Loading: NewsResult()
}
