package com.adrielmadrigal.androidnews.domain.models

data class FullNews(
    val status: String,
    val totalResults: Int,
    val articles: List<NewsArticle>
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