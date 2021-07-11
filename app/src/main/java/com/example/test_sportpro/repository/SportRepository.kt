package com.example.test_sportpro.repository

import com.example.test_sportpro.api.RetrofitInstance

class SportRepository() {
    suspend fun getNews() = RetrofitInstance.api.getNews()

    suspend fun getFilteredNews(sport: Int) = RetrofitInstance.api.getFilteredNews(sport)

    suspend fun getSport(category: Int) = RetrofitInstance.api.getSport(category)
}