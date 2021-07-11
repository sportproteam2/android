package com.example.test_sportpro.repository

import com.example.test_sportpro.api.RetrofitInstance
import retrofit2.Response

class NewsRepository() {
    suspend fun getNews() = RetrofitInstance.api.getNews()

//    suspend fun pushPost(post:Post): Response<Post>{
//        return RetrofitInstance.api.pushPost(post)
//    }
}

