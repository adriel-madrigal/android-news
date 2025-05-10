package com.adrielmadrigal.androidnews.domain.usecases.impl

import com.adrielmadrigal.androidnews.domain.models.FullNews
import com.adrielmadrigal.androidnews.domain.repository.NewsRepository
import com.adrielmadrigal.androidnews.services.NewsResult
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class DefaultFetchNewsArticlesUseCaseTest {

    @MockK
    private lateinit var mockNewsRepository: NewsRepository

    private lateinit var fullNews: FullNews

    @Before
    fun setUp() {
        fullNews = FullNews("ok", 1, listOf())
        mockNewsRepository = mockk<NewsRepository>() {
            coEvery { fetchNews() } returns NewsResult.Success(fullNews)
        }
    }

    @Test
    fun `given newsRepository when create a ProductionFetchNewsArticlesUseCase then return ProductionFetchNewsArticlesUseCase is not null`() {
        // When
        val defaultFetchNewsArticlesUseCase = DefaultFetchNewsArticlesUseCase(mockNewsRepository)

        // Then
        assertNotNull(defaultFetchNewsArticlesUseCase)
    }

    @Test
    fun `given a ProductionFetchNewsArticlesUseCase when invoke is called then return NewsResult`() = runTest {
        // Given
        val defaultFetchNewsArticlesUseCase = DefaultFetchNewsArticlesUseCase(mockNewsRepository)

        // When
        val result = defaultFetchNewsArticlesUseCase()

        // Then
        assertEquals(NewsResult.Success(fullNews), result)
    }


}