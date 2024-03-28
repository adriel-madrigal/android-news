package com.adrielmadrigal.androidnews.newsapi.data.model

data class ArticleModel(
    val title: String,
    val description: String,
    val urlToImage: String? = "",
    val sourceName: String
) {
    override fun toString(): String {
        val stringBuilder = StringBuilder()
        stringBuilder.appendLine("Title = $title")
        stringBuilder.appendLine("Description = $description")
        stringBuilder.appendLine("Url To Image = ${urlToImage?:"No Image"}")
        stringBuilder.appendLine("Source name = $sourceName")
        stringBuilder.appendLine()
        return stringBuilder.toString()
    }
}