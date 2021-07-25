package com.example.test_sportpro.models

data class Creator(
    val document: Any,
    val id: Int,
    val middlename: String,
    val name: String,
    val organization: String,
    val phone: String,
    val region: RegionXX,
    val role: RoleXX,
    val sport: Int,
    val surname: String
)