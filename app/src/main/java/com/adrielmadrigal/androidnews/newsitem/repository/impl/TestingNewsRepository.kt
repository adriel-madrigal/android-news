package com.adrielmadrigal.androidnews.newsitem.repository.impl

import com.adrielmadrigal.androidnews.newsapi.data.model.NewsModel
import com.adrielmadrigal.androidnews.newsitem.repository.NewsRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class TestingNewsRepository @Inject constructor(): NewsRepository {
    //    override fun fetchNews(callback: NewsResultCallback): Single<NewsModel> {
//        TODO("Not yet implemented")
//    }
    override fun fetchNews(): Single<NewsModel> {
        TODO("Not yet implemented")
    }
}