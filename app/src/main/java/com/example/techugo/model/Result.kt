package com.example.techugo.model

data class Result(
    val description_title: String,
    val decription_image: String,
    val description_body: String,
    val banner: ArrayList<String>,
    val latitudes: Float,
    val longitude: Float,
    val cupons: ArrayList<Cupons>

)