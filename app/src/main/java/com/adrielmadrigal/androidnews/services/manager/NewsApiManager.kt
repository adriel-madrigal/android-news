package com.adrielmadrigal.androidnews.newsapi.services.manager

import com.adrielmadrigal.androidnews.NewsResultCallback
import com.adrielmadrigal.androidnews.newsapi.data.model.NewsModel
import com.adrielmadrigal.androidnews.newsapi.data.responses.NewsModelResponse
import com.adrielmadrigal.androidnews.newsapi.services.NewsResult
import io.reactivex.rxjava3.core.Single
import retrofit2.Response

interface NewsApiManager {
    fun fetchRandomNews(): Single<NewsModel>
    fun mapResponseToNewsResult(response: Response<NewsModelResponse>): NewsResult
}