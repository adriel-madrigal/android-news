package com.adrielmadrigal.androidnews.newsitem.viewmodel

import androidx.lifecycle.ViewModel
import com.adrielmadrigal.androidnews.newsapi.services.NewsApiManager
import com.adrielmadrigal.androidnews.newsapi.services.NewsResult
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.BehaviorSubject

class ListNewsCardViewModel(): ViewModel() {

    private val _newsResult = BehaviorSubject.create<NewsResult>()
    val newsResult: Observable<NewsResult>
        get() = _newsResult

    init {
        fetchNews()
    }
    fun fetchNews() {
        _newsResult.onNext(NewsResult.Loading)
        NewsApiManager.getRandomNews()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                _newsResult.onNext(response)
                println("Observer is good")
            }, { error ->
                _newsResult.onNext(NewsResult.Error("Failed to load news: ${error.message}"))
                println("Observer is bad")
            })
    }
}