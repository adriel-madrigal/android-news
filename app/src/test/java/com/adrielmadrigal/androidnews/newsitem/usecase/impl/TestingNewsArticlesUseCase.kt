package com.adrielmadrigal.androidnews.newsitem.usecase.impl

import com.adrielmadrigal.androidnews.newsapi.data.model.ArticleModel
import com.adrielmadrigal.androidnews.newsapi.data.model.NewsModel
import com.adrielmadrigal.androidnews.newsitem.usecase.FetchNewsArticlesUseCase
import io.reactivex.rxjava3.core.Single

class TestingNewsArticlesUseCase: FetchNewsArticlesUseCase {

    override operator fun invoke(): Single<NewsModel> {
        val dummyNewsModel = NewsModel(
            status = "dummy",
            totalResults = 10,
            articles = listOf(
                ArticleModel("Title 1", "Description 1",null, "The Verge"),
                ArticleModel("Title 2", "Description 2",null,"The Verge")
            )
        )
        return Single.just(dummyNewsModel)
    }
}