package com.example.test_sportpro.models

data class UsersItem(
    val document: String,
    val id: Int,
    val middlename: String,
    val name: String,
    val organization: String,
    val phone: String,
    val region: RegionX,
    val role: RoleX,
    val sport: Int,
    val surname: String
)