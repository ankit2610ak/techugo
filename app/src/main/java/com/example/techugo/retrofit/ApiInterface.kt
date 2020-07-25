package com.example.techugo.retrofit

import com.example.techugo.model.TestingData
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    companion object {
        private const val DATA = "testing_data"
    }

    @GET(DATA)
    fun getUserDetails(
    ): Call<ArrayList<TestingData>>


}