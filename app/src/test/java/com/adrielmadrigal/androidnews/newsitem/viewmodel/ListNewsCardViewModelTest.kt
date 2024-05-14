package com.adrielmadrigal.androidnews.newsitem.viewmodel

import androidx.lifecycle.Observer
import com.adrielmadrigal.androidnews.newsapi.services.NewsResult
import com.adrielmadrigal.androidnews.newsitem.usecase.FetchNewsArticlesUseCase
import io.mockk.coEvery
import org.junit.Test
import io.mockk.mockk
import io.mockk.verify
//import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.core.Single
import org.junit.Before

class ListNewsCardViewModelTest {

    private val fetchNewsArticlesUseCase = mockk<FetchNewsArticlesUseCase>()
    private lateinit var listNewsCardViewModel: ListNewsCardViewModel

    @Before
    fun setup() {
        listNewsCardViewModel = ListNewsCardViewModel(fetchNewsArticlesUseCase)
    }

    @Test
    fun `test loading state`() {
        coEvery { fetchNewsArticlesUseCase() } returns Single.never()

        val observer = mockk<Observer<NewsResult>>(relaxed = true)
        listNewsCardViewModel.newsResult.observeForever(observer)
        listNewsCardViewModel.fetchNews()

        verify { observer.onChanged(NewsResult.Loading) }
        listNewsCardViewModel.newsResult.removeObserver(observer)
    }
}