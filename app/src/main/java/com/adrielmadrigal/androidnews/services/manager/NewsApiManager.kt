package com.adrielmadrigal.androidnews.services.manager

//import com.adrielmadrigal.androidnews.data.models.dtos.FullNewsDto
import com.adrielmadrigal.androidnews.services.NewsResult
//import retrofit2.Response

interface NewsApiManager {
    suspend fun fetchRandomNews(): NewsResult
//    fun mapResponseToNewsResult(response: Response<FullNewsDto>): NewsResult
}