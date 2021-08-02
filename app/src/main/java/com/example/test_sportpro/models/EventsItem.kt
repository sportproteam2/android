package com.example.test_sportpro.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class EventsItem(
        @SerializedName("creator")
        val creator: Creator,
        @SerializedName("dateofend")
        val dateofend: String,
        @SerializedName("dateofstart")
        val dateofstart: String,
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
        @SerializedName("players")
        val players: List<Any>,
        @SerializedName("protocol")
        val protocol: Any,
        @SerializedName("sport")
        val sport: Sport,
        @SerializedName("startofWeighing")
        val startofWeighing: String,
        @SerializedName("status")
        val status: String
) : Serializable