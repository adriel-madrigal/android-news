package com.adrielmadrigal.androidnews.domain.usecases

import com.adrielmadrigal.androidnews.domain.models.FullNews

/**
 * Contracts that Fetch the News Articles from the Repository
 */

interface FetchNewsArticlesUseCase {
    /**
     * Overrides the invoke Kotlin function to retrieve the News through the NewsRepository
     * @return Single Observable of the NewsModel
     */
    suspend operator fun invoke(): FullNews
}