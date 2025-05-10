package com.adrielmadrigal.androidnews.services.manager.impl

import com.adrielmadrigal.androidnews.data.models.dtos.FullNewsDto
import com.adrielmadrigal.androidnews.services.NewsResult
import com.adrielmadrigal.androidnews.services.apiservice.NewsApiService
import com.adrielmadrigal.androidnews.services.manager.NewsApiManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultNewsApiManager @Inject constructor(
    private val newsApiService: NewsApiService
): NewsApiManager {
    companion object {
        const val API_BASE_URL = "https://newsapi.org/v2/"
        const val API_KEY = "aad2c04ffcbf4000833a1d948595f63e"
    }

     override suspend fun fetchRandomNews(): NewsResult {
         return withContext(Dispatchers.IO) {
             val result = newsApiService.fetchRandom(
                 "Apple",
                 "2025-05-07",
                 "popularity",
                 API_KEY,
                 15)
             if (result.isSuccessful) {
                 val newsDao: FullNewsDto? = result.body()
                 val news = newsDao?.toNews()
                 if (news == null) {
                     NewsResult.Error("Failed request: Response body is null")
                 } else {
                    NewsResult.Success(news)
                 }
             } else {
                 NewsResult.Error("Failed to fetch news: ${result.code()}")
             }
         }
    }
}