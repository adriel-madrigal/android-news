package com.adrielmadrigal.androidnews.domain.usecases.impl

import com.adrielmadrigal.androidnews.domain.models.FullNews
import com.adrielmadrigal.androidnews.domain.models.NewsArticle
import com.adrielmadrigal.androidnews.domain.usecases.FetchNewsArticlesUseCase
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class PreviewFetchNewsArticleUseCaseImpl @Inject constructor() : FetchNewsArticlesUseCase {

    override operator fun invoke(): Single<FullNews> {
        val dummyNewsModel = FullNews(
            status = "dummy",
            totalResults = 10,
            articles = listOf(
                NewsArticle("Title 1", "Description 1",null, "The Verge"),
                NewsArticle("Title 2", "Description 2",null,"The Verge")
            )
        )
        return Single.just(dummyNewsModel)
    }
}