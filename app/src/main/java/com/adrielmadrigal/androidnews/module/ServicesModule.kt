package com.adrielmadrigal.androidnews.module

import com.adrielmadrigal.androidnews.newsapi.services.apiservice.NewsApiService
import com.adrielmadrigal.androidnews.newsapi.services.manager.NewsApiManager
import com.adrielmadrigal.androidnews.newsapi.services.manager.impl.ProductionNewsApiManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ServicesModule {

    @Provides
    @Singleton
    fun providesNewsApiManager(newsApiService: NewsApiService): NewsApiManager {
        return ProductionNewsApiManager(newsApiService)
    }
}