package com.adrielmadrigal.androidnews.module

import com.adrielmadrigal.androidnews.BuildConfig
import com.adrielmadrigal.androidnews.newsapi.services.manager.NewsApiManager
import com.adrielmadrigal.androidnews.newsitem.repository.NewsRepository
import com.adrielmadrigal.androidnews.newsitem.repository.impl.ProductionNewsRepository
import com.adrielmadrigal.androidnews.newsitem.repository.impl.TestingNewsRepository
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
    fun providesNewsRepository(apiManager: NewsApiManager): NewsRepository {
        return if (BuildConfig.DEBUG) {
            ProductionNewsRepository(apiManager)
        } else {
            TestingNewsRepository()
        }
    }
}