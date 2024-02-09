package com.adrielmadrigal.androidnews.newsapi.model.apiResponse

import com.adrielmadrigal.androidnews.newsapi.model.app.NewsModelApp

data class NewsModelResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<ArticleModelResponse>
) {
    fun toNews(): NewsModelApp {
        val articlesModelApp = articles.map { articleModelResponse -> articleModelResponse.toArticle() }
        return NewsModelApp(
            status = status,
            totalResults = totalResults,
            articles = articlesModelApp
        )
    }
}
