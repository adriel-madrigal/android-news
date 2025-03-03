package com.adrielmadrigal.androidnews.module

import com.adrielmadrigal.androidnews.domain.usecases.FetchNewsArticlesUseCase
import com.adrielmadrigal.androidnews.domain.usecases.impl.ProductionFetchNewsArticlesUseCase
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
        productionFetchNewsArticlesUseCaseImpl: ProductionFetchNewsArticlesUseCase
    ): FetchNewsArticlesUseCase {
        return productionFetchNewsArticlesUseCaseImpl
    }
}