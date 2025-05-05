package com.adrielmadrigal.androidnews.data.models.dtos

import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class NewsArticleDtoTest {

    @MockK
    private lateinit var mockSourceDto: NewsArticleSourceDto

    @Before
    fun setUp() {
        mockSourceDto = mockk<NewsArticleSourceDto>() {
            every { name } returns "Dummy Source Name"
        }
    }

    @Test
    fun `given valid data, when create NewsArticleDto then return NewsArticleDto instance`() {
        // Given
        val title = "Dummy Title"
        val description = "Dummy Description"
        val urlToImage = "http://dummyurl.com/image.jpg"


        // When
        val newsArticleDto = NewsArticleDto(title, description, urlToImage, mockSourceDto)

        // Then
        assertEquals(title, newsArticleDto.title)
        assertEquals(description, newsArticleDto.description)
        assertEquals(urlToImage, newsArticleDto.urlToImage)
    }

    @Test
    fun `given valid data, when convert NewsArticleDto to NewsArticle then return NewsArticle instance`() {
        // Given
        val title = "Dummy Title"
        val description = "Dummy Description"
        val urlToImage = "http://dummyurl.com/image.jpg"
        val newsArticleDto = NewsArticleDto(title, description, urlToImage, mockSourceDto)

        // When
        val newsArticle = newsArticleDto.toArticle()

        // Then
        assertEquals(title, newsArticle.title)
        assertEquals(description, newsArticle.description)
        assertEquals(urlToImage, newsArticle.urlToImage)
        assertEquals(mockSourceDto.name, newsArticle.sourceName)
    }
}