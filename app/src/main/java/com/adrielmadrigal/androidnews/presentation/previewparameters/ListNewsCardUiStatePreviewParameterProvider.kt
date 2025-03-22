package com.adrielmadrigal.androidnews.presentation.previewparameters

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.adrielmadrigal.androidnews.domain.models.FullNews
import com.adrielmadrigal.androidnews.domain.models.NewsArticle
import com.adrielmadrigal.androidnews.presentation.uistates.ListNewsCardUiState

class ListNewsCardUiStatePreviewParameterProvider: PreviewParameterProvider<ListNewsCardUiState> {
    override val values: Sequence<ListNewsCardUiState> = sequenceOf(
        ListNewsCardUiState.Idle,
        ListNewsCardUiState.Loading,
        ListNewsCardUiState.Error("Fetch was not successful"),
        ListNewsCardUiState.Success(
            FullNews("status", 1,emptyList())
        ),
        ListNewsCardUiState.Success(
            FullNews("status", 1,
                listOf(
                    NewsArticle(
                        "title",
                        "description",
                        "https://picsum.photos/100/200",
                        "sourceName"
                    )
                )
            )
        ),
        ListNewsCardUiState.Success(
            FullNews("status", 1,
                listOf(
                    NewsArticle(
                        "title",
                        "description",
                        "https://picsum.photos/100/200",
                        "sourceName"
                    ),
                    NewsArticle(
                        "title",
                        "description",
                        "https://picsum.photos/100/200",
                        "sourceName"
                    ),
                    NewsArticle(
                        "title",
                        "description",
                        "https://picsum.photos/100/200",
                        "sourceName"
                    ),
                    NewsArticle(
                        "title",
                        "description",
                        "https://picsum.photos/100/200",
                        "sourceName"
                    )
                )
            )
        ),
    )
}