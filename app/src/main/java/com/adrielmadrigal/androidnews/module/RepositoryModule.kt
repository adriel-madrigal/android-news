package com.adrielmadrigal.androidnews.module

import com.adrielmadrigal.androidnews.domain.repository.NewsRepository
import com.adrielmadrigal.androidnews.domain.repository.impl.DefaultNewsRepository
import com.adrielmadrigal.androidnews.services.manager.NewsApiManager
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
        return DefaultNewsRepository(apiManager)
//        return if (BuildConfig.DEBUG) {
//            ProductionNewsRepository(apiManager)
//        } else {
//            TestingNewsRepository()
//        }
    }
}