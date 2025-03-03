package com.adrielmadrigal.androidnews.domain.repository.impl

import com.adrielmadrigal.androidnews.domain.models.FullNews
import com.adrielmadrigal.androidnews.domain.repository.NewsRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class TestingNewsRepository @Inject constructor(): NewsRepository {
    override fun fetchNews(): Single<FullNews> {
        TODO("Not yet implemented")
    }
}