package com.adrielmadrigal.androidnews.domain.usecases.impl

import com.adrielmadrigal.androidnews.domain.models.FullNews
import com.adrielmadrigal.androidnews.domain.repository.NewsRepository
import com.adrielmadrigal.androidnews.domain.usecases.FetchNewsArticlesUseCase
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class ProductionFetchNewsArticlesUseCase @Inject constructor(
    private val newsRepository: NewsRepository
): FetchNewsArticlesUseCase {
    override operator fun invoke(): Single<FullNews> {
        return newsRepository.fetchNews()
    }

}