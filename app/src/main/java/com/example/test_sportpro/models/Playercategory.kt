package com.example.test_sportpro.models


import com.google.gson.annotations.SerializedName

data class Playercategory(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)