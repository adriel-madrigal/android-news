package com.adrielmadrigal.androidnews.newsitem.viewmodel

import androidx.lifecycle.ViewModel
import com.adrielmadrigal.androidnews.newsapi.NewsApiService
import com.adrielmadrigal.androidnews.newsapi.NewsResult
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.BehaviorSubject

class ListNewsCardViewModel(private val newsApiService: NewsApiService): ViewModel() {

//    private val _newsResult = BehaviorSubject.create<NewsResult>()
//    val newsResult: Observable<NewsResult>
//        get() = _newsResult
//
//    fun fetchNews() {
//        _newsResult.onNext(NewsResult.Loading)
//        newsApiService.fetchRandom(
//            "Apple",
//            "2023-12-15",
//            "popularity",
//            "aad2c04ffcbf4000833a1d948595f63e"
//        )
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({ response ->
//                _newsResult.onNext(NewsResult.Success(response))
//                println("Observer was good")
//            }, { error ->
//                _newsResult.onNext(NewsResult.Error("Failed to load news: ${error.message}"))
//                println("Observer was bad")
//            })
//    }
}