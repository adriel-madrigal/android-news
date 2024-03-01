package com.adrielmadrigal.androidnews.newsitem.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adrielmadrigal.androidnews.newsapi.services.NewsApiManager
import com.adrielmadrigal.androidnews.newsapi.services.NewsResult
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class ListNewsCardViewModel @Inject constructor(
    private val newsApiManager: NewsApiManager
    ): ViewModel() {

    private val disposable = CompositeDisposable()
    private val _newsResult = MutableLiveData<NewsResult>(NewsResult.Loading)
    val newsResult: LiveData<NewsResult>
        get() = _newsResult

    init {
        fetchNews()
    }

    fun fetchNews() {
        disposable.add(
            newsApiManager.fetchRandomNews { result ->
                println(result)
                _newsResult.postValue(result)
            }
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}