package com.example.test_sportpro.models


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PlayerItem(
    @SerializedName("age")
    val age: Int,
    @SerializedName("dateofadd")
    val dateofadd: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("organization")
    val organization: String,
    @SerializedName("photo")
    val photo: String,
    @SerializedName("playercategory")
    val playercategory: Playercategory,
    @SerializedName("score")
    val score: Int,
    @SerializedName("sex")
    val sex: String,
    @SerializedName("sport")
    val sport: Sport,
    @SerializedName("surname")
    val surname: String,
    @SerializedName("trainer")
    val trainer: Trainer,
    @SerializedName("weight")
    val weight: Int
) : Serializable