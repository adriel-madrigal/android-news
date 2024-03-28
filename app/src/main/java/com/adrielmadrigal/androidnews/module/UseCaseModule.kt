package com.adrielmadrigal.androidnews.module

import com.adrielmadrigal.androidnews.BuildConfig
import com.adrielmadrigal.androidnews.newsitem.usecase.FetchNewsArticlesUseCase
import com.adrielmadrigal.androidnews.newsitem.usecase.impl.ProductionFetchNewsArticlesUseCase
import com.adrielmadrigal.androidnews.newsitem.usecase.impl.PreviewFetchNewsArticleUseCaseImpl
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
        productionFetchNewsArticlesUseCaseImpl: ProductionFetchNewsArticlesUseCase,
        previewFetchNewsArticleUseCaseImpl: PreviewFetchNewsArticleUseCaseImpl
    ): FetchNewsArticlesUseCase {

        return if (BuildConfig.DEBUG) {
            productionFetchNewsArticlesUseCaseImpl
        } else {
            previewFetchNewsArticleUseCaseImpl
        }
    }
}