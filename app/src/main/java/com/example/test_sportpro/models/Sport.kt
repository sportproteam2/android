package com.example.test_sportpro.models


import com.google.gson.annotations.SerializedName

data class Sport(
    @SerializedName("category")
    val category: Category,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)