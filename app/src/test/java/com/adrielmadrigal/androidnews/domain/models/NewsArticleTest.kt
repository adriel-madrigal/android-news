package com.adrielmadrigal.androidnews.domain.models

import org.junit.Assert.assertEquals
import org.junit.Test

class NewsArticleTest {

    @Test
    fun `given valid data, when create NewsArticle then return NewsArticle instance`() {
        // Given
        val title = "Dummy Title"
        val description = "Dummy Description"
        val urlToImage = "http://dummyurl.com/image.jpg"
        val sourceName = "Dummy Source Name"

        // When
        val newsArticle = NewsArticle(
            title = title,
            description = description,
            urlToImage = urlToImage,
            sourceName = sourceName)

        // Then
        assertEquals(title, newsArticle.title)
        assertEquals(description, newsArticle.description)
        assertEquals(urlToImage, newsArticle.urlToImage)
        assertEquals(sourceName, newsArticle.sourceName)
    }

    @Test
    fun `given a news article instance with a valid image url when convert to string then return formatted string representation with image url`() {
        // Given
        val title = "Dummy Title"
        val description = "Dummy Description"
        val urlToImage = "http://dummyurl.com/image.jpg"
        val sourceName = "Dummy Source Name"
        val newsArticle = NewsArticle(
            title = title,
            description = description,
            urlToImage = urlToImage,
            sourceName = sourceName)

        // When
        val stringRepresentation = newsArticle.toString()

        // Then
        val expectedString = """
            Title = $title
            Description = $description
            Url To Image = $urlToImage
            Source name = $sourceName
            """
        assertEquals(expectedString.trimIndent(), stringRepresentation.trimIndent())
    }

    @Test
    fun `given a news article instance with an invalid image url when convert to string then return formatted string representation with no image url`() {
        // Given
        val title = "Dummy Title"
        val description = "Dummy Description"
        val urlToImage = null
        val sourceName = "Dummy Source Name"
        val newsArticle = NewsArticle(
            title = title,
            description = description,
            urlToImage = urlToImage,
            sourceName = sourceName)

        // When
        val stringRepresentation = newsArticle.toString()

        // Then
        val expectedString = """
            Title = $title
            Description = $description
            Url To Image = No Image
            Source name = $sourceName
            """
        assertEquals(expectedString.trimIndent(), stringRepresentation.trimIndent())
    }
}