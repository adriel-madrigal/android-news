package com.adrielmadrigal.androidnews.newsitem.usecase

import com.adrielmadrigal.androidnews.NewsResultCallback

interface FetchNewsArticlesUseCase<in Params, out Result> {
    operator fun invoke(params: Params, callback: NewsResultCallback): Result
}