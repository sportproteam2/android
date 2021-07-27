package com.example.test_sportpro.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class EventsItem(
    @SerializedName("creator")
    val creator: Creator,
    @SerializedName("date")
    val date: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("location")
    val location: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("photo")
    val photo: String,
    @SerializedName("sport")
    val sport: Sport
) : Serializable