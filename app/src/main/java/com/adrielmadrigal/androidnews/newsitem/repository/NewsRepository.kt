package com.adrielmadrigal.androidnews.newsitem.repository

import com.adrielmadrigal.androidnews.NewsResultCallback
import com.adrielmadrigal.androidnews.newsapi.data.model.NewsModel
import io.reactivex.rxjava3.core.Single

interface NewsRepository {
//    fun fetchNews(callback: NewsResultCallback): Single<NewsModel>
    fun fetchNews(): Single<NewsModel>
}