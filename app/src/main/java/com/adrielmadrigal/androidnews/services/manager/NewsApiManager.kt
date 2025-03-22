package com.adrielmadrigal.androidnews.services.manager

import com.adrielmadrigal.androidnews.data.models.dtos.FullNewsDto
import com.adrielmadrigal.androidnews.domain.models.FullNews
import com.adrielmadrigal.androidnews.services.NewsResult
import retrofit2.Response

interface NewsApiManager {
    suspend fun fetchRandomNews(): FullNews
    fun mapResponseToNewsResult(response: Response<FullNewsDto>): NewsResult
}