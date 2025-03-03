package com.adrielmadrigal.androidnews.domain.usecases

import com.adrielmadrigal.androidnews.domain.models.FullNews
import io.reactivex.rxjava3.core.Single

/**
 * Contracts that Fetch the News Articles from the Repository
 */

interface FetchNewsArticlesUseCase {
    /**
     * Overrides the invoke Kotlin function to retrieve the News through the NewsRepository
     * @return Single Observable of the NewsModel
     */
    operator fun invoke(): Single<FullNews>
}