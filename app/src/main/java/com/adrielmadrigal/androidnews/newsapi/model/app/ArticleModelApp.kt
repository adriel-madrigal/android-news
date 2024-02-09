package com.adrielmadrigal.androidnews.newsapi.model.app

data class ArticleModelApp(
    val title: String,
    val description: String,
    val urlToImage: String? = ""
) {
    override fun toString(): String {
        val stringBuilder = StringBuilder()
        stringBuilder.appendLine("Title = $title")
        stringBuilder.appendLine("Description = $description")
        stringBuilder.appendLine("Url To Image = ${urlToImage?:"No Image"}")
        stringBuilder.appendLine()
        return stringBuilder.toString()
    }
}