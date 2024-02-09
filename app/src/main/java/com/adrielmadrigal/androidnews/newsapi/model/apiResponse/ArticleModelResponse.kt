package com.adrielmadrigal.androidnews.newsapi.model.apiResponse

import com.adrielmadrigal.androidnews.newsapi.model.app.ArticleModelApp

data class ArticleModelResponse(
    val title: String,
    val description: String,
    val urlToImage: String?
) {
    fun toArticle(): ArticleModelApp {
        return ArticleModelApp(
            title = title,
            description = description,
            urlToImage = urlToImage
        )
    }
}
