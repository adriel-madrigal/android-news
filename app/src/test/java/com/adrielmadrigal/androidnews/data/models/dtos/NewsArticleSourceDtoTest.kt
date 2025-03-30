package com.adrielmadrigal.androidnews.data.models.dtos

import io.mockk.impl.annotations.MockK
import org.junit.Assert.assertEquals
import org.junit.Test

class NewsArticleSourceDtoTest {

    @Test
    fun `given valid data, when create NewsArticleSourceDto then return NewsArticleSourceDto instance`() {
        // Given
        val id = "dummy-id"
        val name = "Dummy Source Name"

        // When
        val newsArticleSourceDto = NewsArticleSourceDto(id, name)

        // Then
        assertEquals(id, newsArticleSourceDto.id)
        assertEquals(name, newsArticleSourceDto.name)
    }
}