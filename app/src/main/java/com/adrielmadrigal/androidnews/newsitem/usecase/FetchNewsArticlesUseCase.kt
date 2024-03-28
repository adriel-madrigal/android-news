package com.adrielmadrigal.androidnews.newsitem.usecase

import com.adrielmadrigal.androidnews.newsapi.data.model.NewsModel
import io.reactivex.rxjava3.core.Single

//interface FetchNewsArticlesUseCase<in Params, out Result> {
//    operator fun invoke(params: Params, callback: NewsResultCallback): Result
//}

interface FetchNewsArticlesUseCase {
    operator fun invoke(): Single<NewsModel>
}