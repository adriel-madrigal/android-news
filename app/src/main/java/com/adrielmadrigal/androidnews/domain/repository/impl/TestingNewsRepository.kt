package com.adrielmadrigal.androidnews.domain.repository.impl

import com.adrielmadrigal.androidnews.domain.repository.NewsRepository
import com.adrielmadrigal.androidnews.services.NewsResult
import javax.inject.Inject

class TestingNewsRepository @Inject constructor(): NewsRepository {
    override suspend fun fetchNews(): NewsResult {
        TODO("Not yet implemented")
    }
}