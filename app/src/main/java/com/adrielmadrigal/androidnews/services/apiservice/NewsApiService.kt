package com.adrielmadrigal.androidnews.services.apiservice

import com.adrielmadrigal.androidnews.data.models.dtos.FullNewsDto
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("everything")
    fun fetchRandom(
        @Query("q") query: String,
        @Query("from") from: String,
        @Query("sortBy") sortBy: String,
        @Query("apiKey") apiKey: String,
        @Query("pageSize") pageSize: Int
    ): Single<Response<FullNewsDto>>
}