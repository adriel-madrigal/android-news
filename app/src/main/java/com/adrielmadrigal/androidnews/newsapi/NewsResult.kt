package com.adrielmadrigal.androidnews.newsapi

sealed class NewsResult {
    data class Success(val newsResponse: NewsResponse): NewsResult()
    data class Error(val errorMessage: String): NewsResult()
//    data class Loading(val newsResponse: NewsResponse): NewsResult()
    object Loading: NewsResult()
}
