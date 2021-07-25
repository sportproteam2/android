package com.example.test_sportpro.models

data class EventsItem(
    val creator: Creator,
    val date: String,
    val description: String,
    val id: Int,
    val location: String,
    val name: String,
    val photo: String,
    val sport: SportX
)