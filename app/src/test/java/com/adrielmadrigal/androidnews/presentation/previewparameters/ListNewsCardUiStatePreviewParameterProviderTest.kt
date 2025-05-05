package com.adrielmadrigal.androidnews.presentation.previewparameters

import com.adrielmadrigal.androidnews.domain.models.FullNews
import com.adrielmadrigal.androidnews.domain.models.NewsArticle
import com.adrielmadrigal.androidnews.presentation.uistates.ListNewsCardUiState
import org.junit.Assert.assertEquals
import org.junit.Test

class ListNewsCardUiStatePreviewParameterProviderTest {

    @Test
    fun `given a ListNewsCardUiState when create a ListNewsCardUiStatePreviewParameterProvider then return ListNewsCardUiStatePreviewParameterProvider is not null and has data`() {

        // Given
        val errorMessage = "Fetch was not successful"
        val newsArticle = NewsArticle(
            "title",
            "description",
            "https://picsum.photos/100/200",
            "sourceName"
        )
        val emptyFullNews = FullNews("status", 1, emptyList())
        val fullNewsWithOneArticle = FullNews("status", 1, listOf(newsArticle))
        val fullNewsWithFourArticles = FullNews("status", 1, listOf(newsArticle, newsArticle, newsArticle, newsArticle))
        val sequence = sequenceOf(
            ListNewsCardUiState.Idle,
            ListNewsCardUiState.Loading,
            ListNewsCardUiState.Error(errorMessage),
            ListNewsCardUiState.Success(emptyFullNews),
            ListNewsCardUiState.Success(fullNewsWithOneArticle),
            ListNewsCardUiState.Success(fullNewsWithFourArticles)
        )

        // When
        val listNewsCardUiStatePreviewParameterProvider = ListNewsCardUiStatePreviewParameterProvider()

        // Then
        val expectedToList = sequence.toList()
        val actualToList = listNewsCardUiStatePreviewParameterProvider.values.toList()
        assertEquals(expectedToList.size, actualToList.size)
        assertEquals(expectedToList[0], actualToList[0])
        assertEquals(expectedToList[1], actualToList[1])
        assertEquals(expectedToList[2], actualToList[2])
        assertEquals(expectedToList[3], actualToList[3])
        assertEquals(expectedToList[4], actualToList[4])
        assertEquals(expectedToList[5], actualToList[5])
    }
}