package com.adrielmadrigal.androidnews.newsitem.repository.impl

import com.adrielmadrigal.androidnews.NewsResultCallback
import com.adrielmadrigal.androidnews.newsapi.services.NewsApiManager
import com.adrielmadrigal.androidnews.newsapi.services.NewsResult
import com.adrielmadrigal.androidnews.newsitem.repository.NewsRepository
import io.reactivex.rxjava3.disposables.Disposable
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(private val newsApiManager: NewsApiManager): NewsRepository {
    override fun fetchNews(callback: NewsResultCallback): Disposable {
        return newsApiManager.fetchRandomNews(callback)
    }
}