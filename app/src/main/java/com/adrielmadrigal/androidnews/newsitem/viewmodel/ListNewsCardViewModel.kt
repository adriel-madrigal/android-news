package com.adrielmadrigal.androidnews.newsitem.viewmodel

import androidx.lifecycle.ViewModel
import com.adrielmadrigal.androidnews.newsapi.data.model.NewsModel
import com.adrielmadrigal.androidnews.newsitem.usecase.FetchNewsArticlesUseCase
import com.adrielmadrigal.androidnews.newsitem.view.ListNewsCardUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ListNewsCardViewModel @Inject constructor(
    private val fetchNewsArticlesUseCase: FetchNewsArticlesUseCase
    ): ViewModel() {

    private val disposable = CompositeDisposable()
    private val mutableUiState = MutableStateFlow<ListNewsCardUiState>(ListNewsCardUiState.Idle)
    val uiState = mutableUiState.asStateFlow()


    init {
        fetchNews()
    }

    private fun fetchNews() {

        mutableUiState.update {
            ListNewsCardUiState.Loading
        }
        disposable.add(
            fetchNewsArticlesUseCase()
                .flatMap { newsModel ->
                    println(newsModel)
                    val filteredArticles = newsModel.articles.filter { articleModel ->
                        articleModel.title != "[Removed]"
                    }
                    Single.just(newsModel.copy(articles = filteredArticles))
                }
                .subscribe({ newsModel ->
                    handleSuccess(newsModel)
                }, { throwable ->
                    handleError(throwable.message ?: "Unknown error")
                })
        )
    }

    private fun handleSuccess(newsModel: NewsModel) {
        mutableUiState.update {
            ListNewsCardUiState.Success(newsModel)
        }
    }

    private fun handleError(errorMessage: String) {
        mutableUiState.update {
            ListNewsCardUiState.Error
        }
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}