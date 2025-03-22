package com.adrielmadrigal.androidnews.domain.repository.impl

import com.adrielmadrigal.androidnews.domain.models.FullNews
import com.adrielmadrigal.androidnews.domain.repository.NewsRepository
import javax.inject.Inject

class TestingNewsRepository @Inject constructor(): NewsRepository {
    override suspend fun fetchNews(): FullNews {
        TODO("Not yet implemented")
    }
}