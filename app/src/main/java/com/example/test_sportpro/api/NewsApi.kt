package com.example.test_sportpro.api

<<<<<<< HEAD
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
=======
import com.example.test_sportpro.models.DefaultResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface NewsApi {

//    @GET("api/news")
//    suspend fun getNews(): Response<Article>

    @FormUrlEncoded
    @POST("api/user")
    fun createUser(
            @Field("username") username: String,
            @Field("name") name: String,
            @Field("surname") surname: String,
            @Field("phone") phone: String,
//            @Field("role") role: Int,
            @Field("password") password: String,
            @Field("age") age: Int




            ): Call<DefaultResponse>

>>>>>>> d9edcba1ca7f87e942c90d5e84d367545cf90f8d
}