package com.adrielmadrigal.androidnews.newsapi.data.responses

import com.adrielmadrigal.androidnews.newsapi.data.model.ArticleModel

data class ArticleModelResponse(
    val title: String,
    val description: String,
    val urlToImage: String?
) {
    fun toArticle(): ArticleModel {
        return ArticleModel(
            title = title,
            description = description,
            urlToImage = urlToImage
        )
    }
}
