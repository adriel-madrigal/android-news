package com.adrielmadrigal.androidnews.domain.repository

import com.adrielmadrigal.androidnews.domain.models.FullNews
import io.reactivex.rxjava3.core.Single

/**
* This contract is to retrieve news from the News API Manager
* */
interface NewsRepository {
    /**
     * Retrieves a Single Observable of the NewsModel through the News API Manager
    * @return Single Observable of the NewsModel
    * */
    fun fetchNews(): Single<FullNews>
}