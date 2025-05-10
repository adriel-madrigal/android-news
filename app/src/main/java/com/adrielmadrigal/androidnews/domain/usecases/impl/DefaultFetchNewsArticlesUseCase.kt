package com.adrielmadrigal.androidnews.domain.usecases.impl

import com.adrielmadrigal.androidnews.domain.repository.NewsRepository
import com.adrielmadrigal.androidnews.domain.usecases.FetchNewsArticlesUseCase
import com.adrielmadrigal.androidnews.services.NewsResult
import javax.inject.Inject

class DefaultFetchNewsArticlesUseCase @Inject constructor(
    private val newsRepository: NewsRepository
): FetchNewsArticlesUseCase {
    override suspend operator fun invoke(): NewsResult {
        return newsRepository.fetchNews()
    }

}