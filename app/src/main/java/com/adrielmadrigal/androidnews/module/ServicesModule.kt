package com.adrielmadrigal.androidnews.module

import com.adrielmadrigal.androidnews.services.apiservice.NewsApiService
import com.adrielmadrigal.androidnews.services.manager.NewsApiManager
import com.adrielmadrigal.androidnews.services.manager.impl.ProductionNewsApiManager
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