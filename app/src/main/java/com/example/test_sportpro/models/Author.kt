package com.example.test_sportpro.models


import com.google.gson.annotations.SerializedName

data class Author(
    @SerializedName("age")
    val age: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("role")
    val role: Int,
    @SerializedName("surname")
    val surname: String,
    @SerializedName("username")
    val username: String
)