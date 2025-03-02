package com.adrielmadrigal.androidnews.newsapi.data.responses

import com.adrielmadrigal.androidnews.newsapi.data.model.NewsModel

data class NewsModelResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<ArticleModelResponse>
) {
    fun toNews(): NewsModel {
        val articlesModelApp = articles.map { articleModelResponse -> articleModelResponse.toArticle() }
        return NewsModel(
            status = status,
            totalResults = totalResults,
            articles = articlesModelApp
        )
    }
}
