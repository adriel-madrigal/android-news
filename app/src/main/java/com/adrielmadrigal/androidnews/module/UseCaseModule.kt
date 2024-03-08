package com.adrielmadrigal.androidnews.module

import com.adrielmadrigal.androidnews.newsitem.repository.NewsRepository
import com.adrielmadrigal.androidnews.newsitem.usecase.FetchNewsArticlesUseCase
import com.adrielmadrigal.androidnews.newsitem.usecase.impl.DefaultFetchNewsArticlesUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.rxjava3.disposables.Disposable
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun providesFetchNewsArticleUseCase(fetchNewsArticlesUseCase: DefaultFetchNewsArticlesUseCaseImpl): FetchNewsArticlesUseCase<Unit, Disposable> {
        return fetchNewsArticlesUseCase
    }
}