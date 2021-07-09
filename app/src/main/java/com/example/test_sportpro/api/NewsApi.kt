package com.example.test_sportpro.api

import com.example.test_sportpro.models.Article
import com.example.test_sportpro.models.Category
import com.example.test_sportpro.models.Sport
import com.example.test_sportpro.models.SportType
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("api/news")
    suspend fun getNews(): Response<Article>

    @GET("api/news")
    suspend fun getFilteredNews(
            @Query("sport")
            sport: Int
    ): Response<Article>

    @GET("api/sport")
    suspend fun getSport(
            @Query("category")
            category: Int
    ): Response<SportType>
}