package com.example.test_sportpro.api

import com.example.test_sportpro.models.DefaultResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*
import com.example.test_sportpro.models.*


interface NewsApi {

    @GET("api/news")
    suspend fun getNews(): Response<Article>

    @GET("api/newsbysport/1")
    suspend fun getNewsSportOne(): Response<FilteredArticle>

    @GET("api/newsbysport/2")
    suspend fun getNewsSportSecond(): Response<FilteredArticle>

    @GET("api/newsbysport/3")
    suspend fun getNewsSportThird(): Response<FilteredArticle>

    @GET("api/newsbysport/4")
    suspend fun getNewsSportFourth(): Response<FilteredArticle>

    @GET("api/newsbysport/5")
    suspend fun getNewsSportFifth(): Response<FilteredArticle>

    @GET("api/sport")
    suspend fun getAllSport(): Response<SportType>

    @GET("api/sport")
    suspend fun getSport(
        @Query("category")
        category: Int
    ): Response<SportType>

    @GET("api/user")
    suspend fun getUsers(
        @Query("role")
        role: Int
    ): Response<User>

    @GET("api/players")
    suspend fun getPlayers(): Response<Player>

    @FormUrlEncoded
    @POST("api/user/")
    fun createUser(
        @Field("name") name: String,
        @Field("surname") surname: String,
        @Field("middlename") middlename: String,
        @Field("phone") phone: String,
        @Field("role") role: Int,
        @Field("region") region: Int,
        @Field("organization") organization: String,
        @Field("sport") sport: Int,

        @Field("document") document: String,

    ): Call<DefaultResponse>

    @GET("api/event")
    suspend fun getEvents(): Response<Events>

//    @POST("api/player")
//    suspend fun createPlaye(
//        @Body params: Player
//    ): Call<Player>

    @FormUrlEncoded
    @POST("api/players/")
    fun createNewPlayer(
        @Field("name") name: String,
        @Field("surname") surname: String,
        @Field("middlename") middlename: String,

        @Field("age") age: Int,
        @Field("sport") sport: Int,
        @Field("trainer") trainer: Int,

        @Field("sex") sex: String,
        @Field("weight") weight: Int,
        @Field("playercategory") playercategory: Int,

        @Field("photo") photo: String,
        @Field("contact") contact: String


        ): Call<DefaultResponsePlayer>

    @POST("api/user/log")
    fun login(@Body request: LoginRequest): Call<LoginResponse>
}
