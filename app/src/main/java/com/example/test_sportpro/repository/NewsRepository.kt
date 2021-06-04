package com.example.test_sportpro.repository

import com.example.test_sportpro.api.RetrofitInstance
import com.example.test_sportpro.db.ArticleDatabase

class NewsRepository(
    val db: ArticleDatabase
) {
    suspend fun getNews(countryCode: String, category: String, pageNumber: Int) =
        RetrofitInstance.api.getNews(countryCode, category, pageNumber)
}