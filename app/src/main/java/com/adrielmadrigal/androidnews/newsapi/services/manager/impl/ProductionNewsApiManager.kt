package com.adrielmadrigal.androidnews.newsapi.services.manager.impl

import com.adrielmadrigal.androidnews.newsapi.data.responses.NewsModelResponse
import com.adrielmadrigal.androidnews.newsapi.data.model.NewsModel
import com.adrielmadrigal.androidnews.newsapi.services.apiservice.NewsApiService
import com.adrielmadrigal.androidnews.newsapi.services.NewsResult
import com.adrielmadrigal.androidnews.newsapi.services.manager.NewsApiManager
import io.reactivex.rxjava3.core.Single
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

     override fun fetchRandomNews(): Single<NewsModel> {
         return newsApiService.fetchRandom(
             "Apple",
             "2025-02-15",
             "popularity",
             API_KEY,
             15)
             .map { response ->
                 if (response.isSuccessful) {
                     val body: NewsModelResponse? = response.body()
                     body?.toNews() ?: throw RuntimeException("Failed to fetch news: Response body is null")
                 } else {
                     throw RuntimeException("Failed to fetch news: ${response.code()}")
                 }
             }
    }

    override fun mapResponseToNewsResult(response: Response<NewsModelResponse>): NewsResult {
        return when (response.code()) {
            in 200..299 -> {
                val body = response.body()
                if (body != null) {
                    val newsModelApp: NewsModel = body.toNews()
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