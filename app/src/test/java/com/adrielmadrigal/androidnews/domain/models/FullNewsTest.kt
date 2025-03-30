package com.adrielmadrigal.androidnews.domain.models

import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class FullNewsTest {

    @MockK
    private lateinit var mockArticles: List<NewsArticle>

    @Before
    fun setUp() {
        mockArticles = listOf(mockk<NewsArticle>(), mockk<NewsArticle>())
    }

    @Test
    fun `given valid data, when create FullNews then return FullNews instance`() {
        // Given
        val status = "dummy status"
        val totalResults = 2

        // When
        val fullNews = FullNews(status = status, totalResults = totalResults, articles = mockArticles)

        // Then
        assertEquals(status, fullNews.status)
        assertEquals(totalResults, fullNews.totalResults)
        assertEquals(mockArticles, fullNews.articles)
    }

    @Test
    fun `given a full news instance, when convert to string then return formatted string representation`() {
        // Given
        val status = "dummy status"
        val totalResults = 2
        val fullNews = FullNews(status = status, totalResults = totalResults, articles = mockArticles)

        // When
        val stringRepresentation = fullNews.toString()

        // Then
        val expectedString = """
            Status = $status
            Total Results = $totalResults
            List of Articles
            $mockArticles
            """
        assertEquals(expectedString.trimIndent(), stringRepresentation.trimIndent())
    }
}