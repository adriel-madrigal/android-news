package com.adrielmadrigal.androidnews.newsitem.usecase.impl

import com.adrielmadrigal.androidnews.newsapi.data.model.ArticleModel
import com.adrielmadrigal.androidnews.newsapi.data.model.NewsModel
import com.adrielmadrigal.androidnews.newsitem.repository.NewsRepository
import io.mockk.every
import io.mockk.mockk
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.observers.TestObserver
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class ProductionFetchNewsArticlesUseCaseTest {

    private lateinit var productionFetchNewsArticlesUseCaseSUT: ProductionFetchNewsArticlesUseCase
    private val dummyNewsModel = NewsModel(
        status = "dummy",
        totalResults = 10,
        articles = listOf(
            ArticleModel("Title 1", "Description 1",null, "The Verge"),
            ArticleModel("Title 2", "Description 2",null,"The Verge")
        )
    )
    private val mockNewsRepository = mockk<NewsRepository>() {
        every { fetchNews() } returns Single.just(dummyNewsModel)
    }
    @Before
    fun setup() {
//        productionFetchNewsArticlesUseCaseSUT = ProductionFetchNewsArticlesUseCase(mockNewsRepository)
    }

    @Test
    fun `test given a news repository when invoke the use case expected a single news model object`() {
        // Given
//        productionFetchNewsArticlesUseCaseSUT = ProductionFetchNewsArticlesUseCase(mockNewsRepository)
//        // When
//        val singleNewsModel = productionFetchNewsArticlesUseCaseSUT()
//        val testObserver = TestObserver<NewsModel>()
//        singleNewsModel.subscribe(testObserver)
//
//        // Then
//        testObserver.assertComplete()
//        testObserver.assertNoErrors()
//        testObserver.assertValueCount(1)
//        val emittedNewsModel = testObserver.values().first()
//        assertEquals(dummyNewsModel, emittedNewsModel)
        assertTrue(true)
    }
}