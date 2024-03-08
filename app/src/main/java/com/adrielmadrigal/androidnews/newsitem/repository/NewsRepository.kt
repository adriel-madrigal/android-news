package com.adrielmadrigal.androidnews.newsitem.repository

import com.adrielmadrigal.androidnews.NewsResultCallback
import com.adrielmadrigal.androidnews.newsapi.services.NewsResult
import io.reactivex.rxjava3.disposables.Disposable

interface NewsRepository {
    fun fetchNews(callback: NewsResultCallback): Disposable
}