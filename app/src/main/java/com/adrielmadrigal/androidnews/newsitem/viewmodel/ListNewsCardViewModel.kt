package com.adrielmadrigal.androidnews.newsitem.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adrielmadrigal.androidnews.newsapi.data.model.NewsModel
import com.adrielmadrigal.androidnews.newsapi.services.NewsResult
import com.adrielmadrigal.androidnews.newsitem.usecase.FetchNewsArticlesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class ListNewsCardViewModel @Inject constructor(
    private val fetchNewsArticlesUseCase: FetchNewsArticlesUseCase
    ): ViewModel() {

    private val disposable = CompositeDisposable()
    private val _newsResult = MutableLiveData<NewsResult>(NewsResult.Loading)
    val newsResult: LiveData<NewsResult>
        get() = _newsResult

    init {
        fetchNews()
    }

    private fun fetchNews() {
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
        _newsResult.postValue(NewsResult.Success(newsModel))
    }

    private fun handleError(errorMessage: String) {
        _newsResult.postValue(NewsResult.Error(errorMessage))
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}