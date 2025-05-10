package com.adrielmadrigal.androidnews.domain.repository.impl

import com.adrielmadrigal.androidnews.R
import com.adrielmadrigal.androidnews.domain.models.FullNews
import com.adrielmadrigal.androidnews.domain.models.NewsArticle
import com.adrielmadrigal.androidnews.domain.repository.NewsRepository
import com.adrielmadrigal.androidnews.services.NewsResult
import javax.inject.Inject

class FakeNewsRepository @Inject constructor(): NewsRepository {
    override suspend fun fetchNews(): NewsResult {
        val articles = listOf(
            NewsArticle(
                title = "Dummy Title 1",
                description = "Dummy Description 1",
                urlToImage = R.drawable.ic_launcher_background,
                sourceName = "Dummy Source Name 1"
            ),
            NewsArticle(
                title = "Dummy Title 2",
                description = "Dummy Description 2",
                urlToImage = R.drawable.ic_launcher_background,
                sourceName = "Dummy Source Name 2"
            ),
            NewsArticle(
                title = "Dummy Title 3",
                description = "Dummy Description 3",
                urlToImage = R.drawable.ic_launcher_background,
                sourceName = "Dummy Source Name 3"
            ),
            NewsArticle(
                title = "Dummy Title 3",
                description = "Dummy Description 4",
                urlToImage = R.drawable.ic_launcher_background,
                sourceName = "Dummy Source Name 4"
            )
        )
        return NewsResult.Success(
            FullNews(
                status = "ok",
                totalResults = 10,
                articles = articles
            )
        )
    }
}