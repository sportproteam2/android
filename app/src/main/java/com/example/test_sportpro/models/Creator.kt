package com.example.test_sportpro.models

data class Creator(
    val document: Any,
    val id: Int,
    val middlename: String,
    val name: String,
    val organization: String,
    val phone: String,
    val region: Region,
    val role: Role,
    val sport: Int,
    val surname: String
)