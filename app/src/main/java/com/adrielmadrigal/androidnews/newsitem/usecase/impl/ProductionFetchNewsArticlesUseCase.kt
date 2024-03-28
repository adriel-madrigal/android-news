package com.adrielmadrigal.androidnews.newsitem.usecase.impl

import com.adrielmadrigal.androidnews.newsapi.data.model.NewsModel
import com.adrielmadrigal.androidnews.newsitem.repository.NewsRepository
import com.adrielmadrigal.androidnews.newsitem.usecase.FetchNewsArticlesUseCase
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

//class DefaultFetchNewsArticlesUseCaseImpl @Inject constructor(
//    private val newsRepository: NewsRepository
//): FetchNewsArticlesUseCase<Unit, /*Single<NewsResult>*/Disposable> {
//    override operator fun invoke(params: Unit, callback: NewsResultCallback): Disposable {
//        return newsRepository.fetchNews { result ->
//            callback(result)
//        }
//    }
//}

class ProductionFetchNewsArticlesUseCase @Inject constructor(
    private val newsRepository: NewsRepository
): FetchNewsArticlesUseCase {
    override operator fun invoke(): Single<NewsModel> {
        return newsRepository.fetchNews()
    }

}