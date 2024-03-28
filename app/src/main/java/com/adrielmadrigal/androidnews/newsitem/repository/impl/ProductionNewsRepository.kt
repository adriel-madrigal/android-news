package com.adrielmadrigal.androidnews.newsitem.repository.impl

import com.adrielmadrigal.androidnews.newsapi.data.model.NewsModel
import com.adrielmadrigal.androidnews.newsapi.services.manager.NewsApiManager
import com.adrielmadrigal.androidnews.newsitem.repository.NewsRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class ProductionNewsRepository @Inject constructor(private val newsApiManager: NewsApiManager): NewsRepository {
    //    override fun fetchNews(callback: NewsResultCallback): Single<NewsModel> {
////        return newsApiManager.fetchRandomNews(callback)
//        return newsApiManager.fetchRandomNews(callback)
//            .map { response ->
//                if (response.isSuccessful()) {
//                    val articles = response.body()?.articles ?: emptyList()
//                    NewsResult.Success(articles)
//                } else {
//                    NewsResult.Error("Failed to fetch news: ${response.code()}")
//                }
//            }
//            .onErrorReturn { error ->
//                NewsResult.Error(error.message ?: "Unknown error")
//            }
//    }
    override fun fetchNews(): Single<NewsModel> {
        return newsApiManager.fetchRandomNews()
    }
}