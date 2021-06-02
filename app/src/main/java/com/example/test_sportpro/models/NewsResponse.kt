package com.example.test_sportpro.models

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)