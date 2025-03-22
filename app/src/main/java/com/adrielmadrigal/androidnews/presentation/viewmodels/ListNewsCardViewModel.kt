package com.adrielmadrigal.androidnews.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adrielmadrigal.androidnews.domain.models.FullNews
import com.adrielmadrigal.androidnews.domain.models.NewsArticle
import com.adrielmadrigal.androidnews.domain.usecases.FetchNewsArticlesUseCase
import com.adrielmadrigal.androidnews.presentation.uistates.ListNewsCardUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListNewsCardViewModel @Inject constructor(
    private val fetchNewsArticlesUseCase: FetchNewsArticlesUseCase
    ): ViewModel() {

    private val mutableUiState = MutableStateFlow<ListNewsCardUiState>(ListNewsCardUiState.Idle)
    val uiState = mutableUiState.asStateFlow()

    init {
        fetchNews()
    }

    private fun fetchNews() {

        viewModelScope.launch {
            mutableUiState.update {
                ListNewsCardUiState.Loading
            }
            val news = fetchNewsArticlesUseCase()
            val filteredNewsArticles = news.articles.filter { newsArticle: NewsArticle ->
                newsArticle.title != "[Removed]"
            }
            mutableUiState.update {
                val filteredNews = news.copy(articles = filteredNewsArticles)
                ListNewsCardUiState.Success(filteredNews)
            }
        }


//        disposable.add(
//            fetchNewsArticlesUseCase()
//                .flatMap { fullNews ->
//                    println(fullNews)
//                    val filteredArticles = fullNews.articles.filter { articleModel ->
//                        articleModel.title != "[Removed]"
//                    }
//                    Single.just(fullNews.copy(articles = filteredArticles))
//                }
//                .subscribe({ fullNews ->
//                    handleSuccess(fullNews)
//                }, { throwable ->
//                    handleError(throwable.message ?: "Unknown error")
//                })
//        )
    }

    private fun handleSuccess(fullNews: FullNews) {
        mutableUiState.update {
            ListNewsCardUiState.Success(fullNews)
        }
    }

    private fun handleError(errorMessage: String) {
        mutableUiState.update {
            ListNewsCardUiState.Error
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}