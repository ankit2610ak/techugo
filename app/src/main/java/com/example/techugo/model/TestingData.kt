package com.example.techugo.model

data class TestingData(
    val result: Result,
    val banner: ArrayList<String>,
    val latitudes: Long,
    val longitude: Long,
    val cupons: ArrayList<Cupons>
)