package com.adrielmadrigal.androidnews.newsapi.services

import com.adrielmadrigal.androidnews.newsapi.model.apiResponse.NewsModelResponse
import com.adrielmadrigal.androidnews.newsapi.model.app.NewsModelApp
import io.reactivex.rxjava3.core.Single
import retrofit2.Response

object NewsApiManager {
    val API_BASE_URL = "https://newsapi.org/v2/"
    val API_KEY = "aad2c04ffcbf4000833a1d948595f63e"

    private val news by lazy {
        NewsApiService.create()
    }

    fun getRandomNews(): Single<NewsResult> {
        return news.fetchRandom("Apple",
            "2024-01-20",
            "popularity",
            API_KEY,
        15)
            .map(this::newsResponse)
    }

    private fun newsResponse(response: Response<NewsModelResponse>): NewsResult {
        return when (response.code()) {
            in 200..300 -> {
                val body = response.body()
                if (body != null) {
                    val newsModelApp: NewsModelApp = body.toNews().copy()
                    println(newsModelApp.toString())
                    NewsResult.Success(newsModelApp)
                } else {
                    NewsResult.Error("Failed request")
                }
            }
            in 400..500 -> NewsResult.Error("Error below of 400 or above 500")
            else -> NewsResult.Error("Server Failed")
        }
    }
}