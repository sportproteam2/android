package com.example.test_sportpro.models


import com.google.gson.annotations.SerializedName

data class Trainer(
    @SerializedName("document")
    val document: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("middlename")
    val middlename: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("organization")
    val organization: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("region")
    val region: Region,
    @SerializedName("role")
    val role: Role,
    @SerializedName("sport")
    val sport: Int,
    @SerializedName("surname")
    val surname: String
)