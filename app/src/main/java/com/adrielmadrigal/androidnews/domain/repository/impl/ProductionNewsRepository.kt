package com.adrielmadrigal.androidnews.domain.repository.impl

import com.adrielmadrigal.androidnews.domain.models.FullNews
import com.adrielmadrigal.androidnews.domain.repository.NewsRepository
import com.adrielmadrigal.androidnews.services.manager.NewsApiManager
import javax.inject.Inject

class ProductionNewsRepository @Inject constructor(private val newsApiManager: NewsApiManager
): NewsRepository {
    override suspend fun fetchNews(): FullNews {
        return newsApiManager.fetchRandomNews()
    }
}