package com.adrielmadrigal.androidnews.presentation.uistates

import com.adrielmadrigal.androidnews.domain.models.FullNews

sealed class FullNewsUiState {
    data object Idle: FullNewsUiState()
    data object Loading: FullNewsUiState()
    data class Success(val fullNews: FullNews): FullNewsUiState()
    data object Error: FullNewsUiState()

}