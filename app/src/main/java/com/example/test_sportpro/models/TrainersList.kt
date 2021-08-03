package com.example.test_sportpro.models

data class TrainersList(
    val count: Int,
    val next: Any,
    val previous: Any,
    val results: List<Result>
)