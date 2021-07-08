package com.example.test_sportpro.api

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

}