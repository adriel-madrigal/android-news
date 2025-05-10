package com.adrielmadrigal.androidnews.domain.repository.impl

import com.adrielmadrigal.androidnews.domain.repository.NewsRepository
import com.adrielmadrigal.androidnews.services.NewsResult
import com.adrielmadrigal.androidnews.services.manager.NewsApiManager
import javax.inject.Inject

class DefaultNewsRepository @Inject constructor(
    private val newsApiManager: NewsApiManager
): NewsRepository {
    override suspend fun fetchNews(): NewsResult {
        return newsApiManager.fetchRandomNews()
    }
}