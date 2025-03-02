package com.adrielmadrigal.androidnews.newsitem.view

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.adrielmadrigal.androidnews.newsapi.data.model.ArticleModel
import com.adrielmadrigal.androidnews.newsapi.data.model.NewsModel
import com.adrielmadrigal.androidnews.newsapi.services.NewsResult

class ListNewsCardUiStatePreviewParameterProvider: PreviewParameterProvider<ListNewsCardUiState> {
    override val values: Sequence<ListNewsCardUiState> = sequenceOf(
        ListNewsCardUiState.Idle,
        ListNewsCardUiState.Loading,
        ListNewsCardUiState.Error,
        ListNewsCardUiState.Success(
            NewsModel("status", 1,emptyList())
        ),
        ListNewsCardUiState.Success(
            NewsModel("status", 1,
                listOf(
                    ArticleModel(
                        "title",
                        "description",
                        "https://picsum.photos/100/200",
                        "sourceName"
                    )
                )
            )
        ),
        ListNewsCardUiState.Success(
            NewsModel("status", 1,
                listOf(
                    ArticleModel(
                        "title",
                        "description",
                        "https://picsum.photos/100/200",
                        "sourceName"
                    ),
                    ArticleModel(
                        "title",
                        "description",
                        "https://picsum.photos/100/200",
                        "sourceName"
                    ),
                    ArticleModel(
                        "title",
                        "description",
                        "https://picsum.photos/100/200",
                        "sourceName"
                    ),
                    ArticleModel(
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