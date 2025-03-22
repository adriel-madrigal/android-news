package com.adrielmadrigal.androidnews.services.manager.impl

import com.adrielmadrigal.androidnews.data.models.dtos.FullNewsDto
import com.adrielmadrigal.androidnews.domain.models.FullNews
import com.adrielmadrigal.androidnews.services.NewsResult
import com.adrielmadrigal.androidnews.services.apiservice.NewsApiService
import com.adrielmadrigal.androidnews.services.manager.NewsApiManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductionNewsApiManager @Inject constructor(
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
                 "2025-03-21",
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

    override fun mapResponseToNewsResult(response: Response<FullNewsDto>): NewsResult {
        return when (response.code()) {
            in 200..299 -> {
                val body = response.body()
                if (body != null) {
                    val newsModelApp: FullNews = body.toNews()
                    NewsResult.Success(newsModelApp)
                } else {
                    NewsResult.Error("Failed request: Response body is null")
                }
            }
            in 400..499 -> NewsResult.Error("Client error: ${response.code()}")
            in 500..599 -> NewsResult.Error("Server error: ${response.code()}")
            else -> NewsResult.Error("Unexpected error: ${response.code()}")
        }
    }
}