package com.adrielmadrigal.androidnews.services.manager.impl

import com.adrielmadrigal.androidnews.data.models.dtos.FullNewsDto
import com.adrielmadrigal.androidnews.domain.models.FullNews
import com.adrielmadrigal.androidnews.services.NewsResult
import com.adrielmadrigal.androidnews.services.apiservice.NewsApiService
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class DefaultNewsApiManagerTest {

    @MockK
    private lateinit var mockNewsApiService: NewsApiService

    @Before
    fun setUp() {

    }

    @Test
    fun `given a NewsApiService when create a ProductionNewsApiManager then return ProductionNewsApiManager is not null`( ) {
        // When
        mockNewsApiService = mockk<NewsApiService>()
        val defaultNewsApiManager = DefaultNewsApiManager(mockNewsApiService)

        // Then
        assertNotNull(defaultNewsApiManager)
    }

    @Test
    fun `give a valid request when fetchRandomNews is called then return NewsResult Success`() = runTest {
        // Given
        val fullNews = FullNews(status = "ok", totalResults =  1, articles = listOf())
        val mockResponseSuccess = mockk<Response<FullNewsDto>>() {
            coEvery { isSuccessful } returns true
            coEvery { body() } returns mockk<FullNewsDto>() {
                every { toNews() } returns fullNews
            }
        }
        mockNewsApiService = mockk<NewsApiService>() {
            coEvery { fetchRandom(ofType(), ofType(), ofType(), ofType(), ofType(),) } returns mockResponseSuccess
        }
        val defaultNewsApiManager = DefaultNewsApiManager(mockNewsApiService)

        // When
        val newsResult = defaultNewsApiManager.fetchRandomNews()

        // Then
        assertEquals(NewsResult.Success(fullNews), newsResult)
        coVerify { mockNewsApiService.fetchRandom(ofType(), ofType(), ofType(), ofType(), ofType()) }
        coVerify { mockResponseSuccess.isSuccessful }
        coVerify(exactly = 1) { mockResponseSuccess.body() }
    }

    @Test
    fun `give a valid request when fetchRandomNews is called then return NewsResult Error with null body`() = runTest {
        // Given
        val mockResponseSuccess = mockk<Response<FullNewsDto>>() {
            coEvery { isSuccessful } returns true
            coEvery { body() } returns null
        }
        mockNewsApiService = mockk<NewsApiService>() {
            coEvery { fetchRandom(ofType(), ofType(), ofType(), ofType(), ofType(),) } returns mockResponseSuccess
        }
        val defaultNewsApiManager = DefaultNewsApiManager(mockNewsApiService)

        // When
        val newsResult = defaultNewsApiManager.fetchRandomNews()

        // Then
        val expectedErrorMessage = "Failed request: Response body is null"
        assertEquals(NewsResult.Error(expectedErrorMessage), newsResult)
        coVerify { mockNewsApiService.fetchRandom(ofType(), ofType(), ofType(), ofType(), ofType()) }
        coVerify { mockResponseSuccess.isSuccessful }
        coVerify(exactly = 1) { mockResponseSuccess.body() }
    }

    @Test
    fun `give an invalid request when fetchRandomNews is called then return NewsResult Error`() = runTest {
        // Given
        val mockResponseSuccess = mockk<Response<FullNewsDto>>() {
            coEvery { isSuccessful } returns false
            coEvery { code() } returns 400
        }
        mockNewsApiService = mockk<NewsApiService>() {
            coEvery { fetchRandom(ofType(), ofType(), ofType(), ofType(), ofType(),) } returns mockResponseSuccess
        }
        val defaultNewsApiManager = DefaultNewsApiManager(mockNewsApiService)

        // When
        val newsResult = defaultNewsApiManager.fetchRandomNews()

        // Then
        val expectedErrorMessage = "Failed to fetch news: 400"
        assertEquals(NewsResult.Error(expectedErrorMessage), newsResult)
        coVerify { mockNewsApiService.fetchRandom(ofType(), ofType(), ofType(), ofType(), ofType()) }
        coVerify { mockResponseSuccess.isSuccessful }
        coVerify(exactly = 0) { mockResponseSuccess.body() }
    }
}