package com.adrielmadrigal.androidnews.domain.repository.impl

import com.adrielmadrigal.androidnews.domain.models.FullNews
import com.adrielmadrigal.androidnews.services.NewsResult
import com.adrielmadrigal.androidnews.services.manager.NewsApiManager
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class DefaultNewsRepositoryTest {

    @MockK
    private lateinit var mockNewsApiManager: NewsApiManager

    private lateinit var fullNews: FullNews

    @Before
    fun setUp() {
        fullNews = FullNews("ok", 1, listOf())

        mockNewsApiManager = mockk<NewsApiManager>() {
            coEvery { fetchRandomNews() } returns NewsResult.Success(fullNews)
        }
    }

    @Test
    fun `given a newsApiManager when create a ProductionNewsRepository then return ProductionNewsRepository is not null`() {
        // When
        val defaultNewsRepository = DefaultNewsRepository(mockNewsApiManager)

        // Then
        assertNotNull(defaultNewsRepository)
    }

    @Test
    fun `given a ProductionNewsRepository when fetchNews is called then return NewsResult`() = runTest {
        // Given
        val defaultNewsRepository = DefaultNewsRepository(mockNewsApiManager)

        // When
        val result = defaultNewsRepository.fetchNews()

        // Then
        assertEquals(NewsResult.Success(fullNews), result)
    }

}