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

//    @GET("api/user")
//    suspend fun getUser(
//        @Query("role")
//        role: Role
//    ): Response<>
    @GET("api/user")
    suspend fun getUsers(): Response<User>

    @FormUrlEncoded
    @POST("api/user/")
    fun createUser(
        @Field("name") name: String,
        @Field("surname") surname: String,
        @Field("middlename") middlename: String,
        @Field("phone") phone: String,
        @Field("role") role: Role,
        @Field("region") region: Region,
        @Field("organization") organization: String,
        @Field("sport") sport: Int,
        @Field("password") password: String,
        @Field("document") document: String,

    ): Call<DefaultResponse>

    @GET("api/players")
    suspend fun getPlayers(): Response<Player>
}
