package com.example.test_sportpro.api


import com.example.test_sportpro.models.Article
import com.example.test_sportpro.models.DefaultResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

import com.example.test_sportpro.models.*

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

    @FormUrlEncoded
    @POST("api/user/")
    fun createUser(
            @Field("username") username: String,
            @Field("name") name: String,
            @Field("surname") surname: String,
            @Field("phone") phone: String,
            @Field("role") role: Int,
            @Field("password") password: String,
            @Field("age") age: Int
            ): Call<DefaultResponse>

}
