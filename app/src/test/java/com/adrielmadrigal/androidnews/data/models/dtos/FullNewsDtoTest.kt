package com.adrielmadrigal.androidnews.data.models.dtos

import com.adrielmadrigal.androidnews.domain.models.NewsArticle
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class FullNewsDtoTest {

    @MockK
    private lateinit var mockArticlesDto: List<NewsArticleDto>

    @Before
    fun setUp() {
        val mockArticle = mockk<NewsArticleDto>() {
            every { toArticle() } returns mockk<NewsArticle>()
        }
        mockArticlesDto = listOf(mockArticle, mockArticle, mockArticle)
    }

    @Test
    fun `given valid data, when create FullNewsDto then return FullNewsDto instance`() {
        // Given
        val status = "1"
        val totalResults = 3

        // When
        val fullNewsDto = FullNewsDto(status, totalResults, mockArticlesDto)

        // Then
        assertEquals(status, fullNewsDto.status)
        assertEquals(totalResults, fullNewsDto.totalResults)
        assertEquals(mockArticlesDto, fullNewsDto.articles)
    }

    @Test
    fun `given valid data, when convert FullNewsDto to FullNews then return FullNews instance`() {
        // Given
        val status = "1"
        val totalResults = 3
        val fullNewsDto = FullNewsDto(status, totalResults, mockArticlesDto)

        // When
        val fullNews = fullNewsDto.toNews()

        // Then
        assertEquals(status, fullNews.status)
        assertEquals(totalResults, fullNews.totalResults)
        assertEquals(mockArticlesDto.size, fullNews.articles.size)
    }
}