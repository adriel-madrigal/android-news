package com.adrielmadrigal.androidnews.services

import com.adrielmadrigal.androidnews.domain.models.FullNews
import com.adrielmadrigal.androidnews.domain.models.NewsArticle
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Test

class NewsResultTest {

    @Test
    fun `given FullNews when create a NewsResult Success then return Success`() {
        // Given
        val status = "ok"
        val totalResults = 1
        val mockkArticles = listOf(mockk<NewsArticle>(), mockk<NewsArticle>())
        val fullNews = FullNews(status = status, totalResults = totalResults, articles = mockkArticles)

        // When
        val newsResult = NewsResult.Success(fullNews)

        // Then
        assertEquals(fullNews, newsResult.newsResponse)
    }

    @Test
    fun `given errorMessage when create a NewsResult Error then return Error`() {
        // Given
        val errorMessage = "Error message"

        // When
        val newsResult = NewsResult.Error(errorMessage)

        // Then
        assertEquals(errorMessage, newsResult.errorMessage)
    }

    @Test
    fun `given NewsResult Loading when create a NewsResult Loading then return Loading`() {
        // When
        val newsResult = NewsResult.Loading

        // Then
        assertEquals(NewsResult.Loading, newsResult)
    }
}