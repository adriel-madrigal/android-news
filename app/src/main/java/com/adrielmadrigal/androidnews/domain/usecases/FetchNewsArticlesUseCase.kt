package com.adrielmadrigal.androidnews.newsitem.usecase

import com.adrielmadrigal.androidnews.newsapi.data.model.NewsModel
import io.reactivex.rxjava3.core.Single

/**
 * Contracts that Fetch the News Articles from the Repository
 */

interface FetchNewsArticlesUseCase {
    /**
     * Overrides the invoke Kotlin function to retrieve the News through the NewsRepository
     * @return Single Observable of the NewsModel
     */
    operator fun invoke(): Single<NewsModel>
}