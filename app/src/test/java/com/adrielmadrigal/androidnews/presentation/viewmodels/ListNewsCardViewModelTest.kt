package com.adrielmadrigal.androidnews.presentation.viewmodels

import com.adrielmadrigal.androidnews.domain.models.FullNews
import com.adrielmadrigal.androidnews.domain.models.NewsArticle
import com.adrielmadrigal.androidnews.domain.usecases.FetchNewsArticlesUseCase
import com.adrielmadrigal.androidnews.presentation.uistates.ListNewsCardUiState
import com.adrielmadrigal.androidnews.services.NewsResult
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Ignore
import org.junit.Test

class ListNewsCardViewModelTest {

    @MockK
    private lateinit var mockFetchNewsArticlesUseCase: FetchNewsArticlesUseCase

    private lateinit var viewModel: ListNewsCardViewModel

    @MockK
    private lateinit var mockMutableUiState: MutableStateFlow<ListNewsCardUiState>

    @Before
    fun setUp() {
        mockFetchNewsArticlesUseCase = mockk {

        }
    }

    @Ignore("Fix this test")
    @Test
    fun `given a valid response when fetchNews is called then update uiState with Success`() = runTest {
        // Given
        val newsArticle = NewsArticle("title [Removed]", "content", "urlToImage", "sourceName")
        val mockFullNews = mockk<FullNews> {
            every { articles } returns listOf(
                newsArticle,
                newsArticle,
                newsArticle,
                NewsArticle("A [Removed]", "content", "urlToImage", "sourceName"))
            every { status } returns "status"
            every { totalResults } returns 3
        }
        coEvery { mockFetchNewsArticlesUseCase() } returns NewsResult.Success(mockFullNews)

        // When
        viewModel = spyk(ListNewsCardViewModel(mockFetchNewsArticlesUseCase))
//        advanceUntilIdle()
        // Then
        val uiState: ListNewsCardUiState = viewModel.uiState.value

    }

    @Ignore("UiState validation is hard")
    @Test
    fun `given an invalid response when fetchNews is called then update uiState with Error`() {

    }
}