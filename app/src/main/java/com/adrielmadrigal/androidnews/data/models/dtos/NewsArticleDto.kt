package com.adrielmadrigal.androidnews.data.models.dtos

import com.adrielmadrigal.androidnews.domain.models.NewsArticle

data class NewsArticleDto(
    val title: String,
    val description: String,
    val urlToImage: String?,
    val source: NewsArticleSourceDto
) {
    fun toArticle(): NewsArticle {
        return NewsArticle(
            title = title,
            description = description,
            urlToImage = urlToImage,
            sourceName = source.name
        )
    }
}
