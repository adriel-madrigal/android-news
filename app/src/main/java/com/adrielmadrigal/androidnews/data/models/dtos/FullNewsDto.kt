package com.adrielmadrigal.androidnews.data.models.dtos

import com.adrielmadrigal.androidnews.domain.models.FullNews

data class FullNewsDto(
    val status: String,
    val totalResults: Int,
    val articles: List<NewsArticleDto>
) {
    fun toNews(): FullNews {
        val articlesModelApp = articles.map { articleModelResponse -> articleModelResponse.toArticle() }
        return FullNews(
            status = status,
            totalResults = totalResults,
            articles = articlesModelApp
        )
    }
}
