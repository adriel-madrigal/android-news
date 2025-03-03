package com.adrielmadrigal.androidnews.services

import com.adrielmadrigal.androidnews.domain.models.FullNews

sealed class NewsResult {
    data class Success(val newsResponse: FullNews): NewsResult()
    data class Error(val errorMessage: String): NewsResult()
    object Loading: NewsResult()
}
