package com.example.test_sportpro.repository

import com.example.test_sportpro.api.RetrofitInstance

class SportRepository() {
    suspend fun getNews() = RetrofitInstance.api.getNews()

    suspend fun getNewsSportOne() = RetrofitInstance.api.getNewsSportOne()

    suspend fun getNewsSportSecond() = RetrofitInstance.api.getNewsSportSecond()

    suspend fun getNewsSportThird() = RetrofitInstance.api.getNewsSportThird()

    suspend fun getNewsSportFourth() = RetrofitInstance.api.getNewsSportFourth()

    suspend fun getNewsSportFifth() = RetrofitInstance.api.getNewsSportFifth()

    suspend fun getAllSport() = RetrofitInstance.api.getAllSport()

    suspend fun getSport(category: Int) = RetrofitInstance.api.getSport(category)

    suspend fun getJudges() = RetrofitInstance.api.getJudges()

    suspend fun getTrainers() = RetrofitInstance.api.getTrainers()

    suspend fun getEvents() = RetrofitInstance.api.getEvents()

    suspend fun getPlayers() = RetrofitInstance.api.getPlayers()


}