package com.adrielmadrigal.androidnews.newsapi.data.model

data class NewsModel(
    val status: String,
    val totalResults: Int,
    val articles: List<ArticleModel>
) {
    override fun toString(): String {
        val stringBuilder = StringBuilder()
        stringBuilder.appendLine("Status = $status")
        stringBuilder.appendLine("Total Results = $totalResults")
        stringBuilder.appendLine("List of Articles")
        stringBuilder.appendLine(articles)
        return stringBuilder.toString()
    }
}