package com.example.test_sportpro.api

import com.example.test_sportpro.models.Article
import retrofit2.Response
import retrofit2.http.GET

interface NewsApi {

    @GET("api/news")
    suspend fun getNews(): Response<Article>
}