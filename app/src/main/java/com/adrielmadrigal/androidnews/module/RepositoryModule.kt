package com.adrielmadrigal.androidnews.module

import com.adrielmadrigal.androidnews.newsapi.services.NewsApiManager
import com.adrielmadrigal.androidnews.newsitem.repository.NewsRepository
import com.adrielmadrigal.androidnews.newsitem.repository.impl.NewsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun providesNewsRepository(apiNewsApiManager: NewsApiManager): NewsRepository {
        return NewsRepositoryImpl(apiNewsApiManager)
    }
}