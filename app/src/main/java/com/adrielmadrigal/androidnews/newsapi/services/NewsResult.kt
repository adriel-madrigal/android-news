package com.adrielmadrigal.androidnews.newsapi.services

import com.adrielmadrigal.androidnews.newsapi.data.model.NewsModel

sealed class NewsResult {
    data class Success(val newsResponse: NewsModel): NewsResult()
    data class Error(val errorMessage: String): NewsResult()
    object Loading: NewsResult()
}
