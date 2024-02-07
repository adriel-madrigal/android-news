package com.adrielmadrigal.androidnews.newsapi

data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)
