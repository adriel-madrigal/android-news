package com.adrielmadrigal.androidnews.newsitem.usecase.impl

import com.adrielmadrigal.androidnews.NewsResultCallback
import com.adrielmadrigal.androidnews.newsapi.services.NewsResult
import com.adrielmadrigal.androidnews.newsitem.repository.NewsRepository
import com.adrielmadrigal.androidnews.newsitem.usecase.FetchNewsArticlesUseCase
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.Disposable
import javax.inject.Inject

class DefaultFetchNewsArticlesUseCaseImpl @Inject constructor(
    private val newsRepository: NewsRepository
): FetchNewsArticlesUseCase<Unit, /*Single<NewsResult>*/Disposable> {
    override operator fun invoke(params: Unit, callback: NewsResultCallback): Disposable {
        return newsRepository.fetchNews { result ->
            callback(result)
        }
    }
}