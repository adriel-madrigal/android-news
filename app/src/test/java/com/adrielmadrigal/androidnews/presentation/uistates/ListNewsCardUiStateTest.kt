package com.adrielmadrigal.androidnews.presentation.uistates

import com.adrielmadrigal.androidnews.domain.models.FullNews
import org.junit.Assert.assertEquals
import org.junit.Test

class ListNewsCardUiStateTest {

    @Test
    fun `given a Idle when create a ListNewsCardUiState then return Idle ListNewsCardUiState`() {
        // When
        val listNewsCardUiState = ListNewsCardUiState.Idle

        // Then
        assertEquals(ListNewsCardUiState.Idle, listNewsCardUiState)
    }

    @Test
    fun `given a Loading when create a ListNewsCardUiState then return Loading ListNewsCardUiState`() {
        // When
        val listNewsCardUiState = ListNewsCardUiState.Loading

        // Then
        assertEquals(ListNewsCardUiState.Loading, listNewsCardUiState)
    }

    @Test
    fun `given a Success when create a ListNewsCardUiState then return Success ListNewsCardUiState`() {
        // Given
        val fullNews = FullNews("status", 1, emptyList())

        // When
        val listNewsCardUiState = ListNewsCardUiState.Success(fullNews)

        // Then
        assertEquals(ListNewsCardUiState.Success(fullNews), listNewsCardUiState)
    }

    @Test
    fun `given a Error when create a ListNewsCardUiState then return Error ListNewsCardUiState`() {
        // Given
        val errorMessage = "Fetch was not successful"

        // When
        val listNewsCardUiState = ListNewsCardUiState.Error(errorMessage)

        // Then
        assertEquals(ListNewsCardUiState.Error(errorMessage), listNewsCardUiState)
    }
}