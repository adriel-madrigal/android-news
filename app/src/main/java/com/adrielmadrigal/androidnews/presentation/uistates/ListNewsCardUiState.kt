package com.adrielmadrigal.androidnews.presentation.uistates

import com.adrielmadrigal.androidnews.domain.models.FullNews

sealed class ListNewsCardUiState {
    data object Idle: ListNewsCardUiState()
    data object Loading: ListNewsCardUiState()
    data class Success(val fullNews: FullNews): ListNewsCardUiState()
    data object Error: ListNewsCardUiState()

}