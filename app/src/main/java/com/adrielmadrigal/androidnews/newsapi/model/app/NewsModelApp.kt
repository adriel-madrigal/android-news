package com.adrielmadrigal.androidnews.newsapi.model.app

data class NewsModelApp(
    val status: String,
    val totalResults: Int,
    val articles: List<ArticleModelApp>
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