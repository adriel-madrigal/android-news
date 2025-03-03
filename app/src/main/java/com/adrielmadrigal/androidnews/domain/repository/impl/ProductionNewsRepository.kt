package com.adrielmadrigal.androidnews.domain.repository.impl

import com.adrielmadrigal.androidnews.domain.models.FullNews
import com.adrielmadrigal.androidnews.domain.repository.NewsRepository
import com.adrielmadrigal.androidnews.services.manager.NewsApiManager
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class ProductionNewsRepository @Inject constructor(private val newsApiManager: NewsApiManager):
    NewsRepository {
    override fun fetchNews(): Single<FullNews> {
        return newsApiManager.fetchRandomNews()
    }
}