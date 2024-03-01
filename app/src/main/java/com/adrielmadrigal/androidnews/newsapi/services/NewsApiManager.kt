package com.adrielmadrigal.androidnews.newsapi.services

import com.adrielmadrigal.androidnews.newsapi.data.responses.NewsModelResponse
import com.adrielmadrigal.androidnews.newsapi.data.model.NewsModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsApiManager @Inject constructor(private val newsApiService: NewsApiService) {
    companion object {
        const val API_BASE_URL = "https://newsapi.org/v2/"
        const val API_KEY = "aad2c04ffcbf4000833a1d948595f63e"
    }

     fun fetchRandomNews(callback: (NewsResult) -> Unit): Disposable {
         return newsApiService.fetchRandom(
             "Apple",
             "2024-02-15",
             "popularity",
             API_KEY,
             10)
             .subscribeOn(Schedulers.io())
             .observeOn(AndroidSchedulers.mainThread())
             .subscribe(
                  { response ->
                     if (response.isSuccessful) {
                         val newsModelApp: NewsModel = response.body()?.toNews() ?: throw IOException("Failed to fetch news")
                         callback(NewsResult.Success(newsModelApp))
                     } else {
                         callback(NewsResult.Error("Failed to fetch news: ${response.code()}"))
                     }
                 },
                 { throwable ->
                     callback(NewsResult.Error("Error fetching news: ${throwable.message}"))
                 }
             )
    }

    private fun mapResponseToNewsResult(response: Response<NewsModelResponse>): NewsResult {
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