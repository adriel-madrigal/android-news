package com.adrielmadrigal.androidnews.module

import com.adrielmadrigal.androidnews.domain.usecases.FetchNewsArticlesUseCase
import com.adrielmadrigal.androidnews.domain.usecases.GetLatestDateUseCase
import com.adrielmadrigal.androidnews.domain.usecases.impl.DefaultFetchNewsArticlesUseCase
import com.adrielmadrigal.androidnews.domain.usecases.impl.DefaultGetLatestDateUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun providesFetchNewsUseCase(
        defaultFetchNewsArticlesUseCaseImpl: DefaultFetchNewsArticlesUseCase
    ): FetchNewsArticlesUseCase {
        return defaultFetchNewsArticlesUseCaseImpl
    }

    @Provides
    @Singleton
    fun provideGetLatestDateUseCase(): GetLatestDateUseCase {
        return DefaultGetLatestDateUseCase()
    }
}