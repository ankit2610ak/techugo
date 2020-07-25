package com.example.techugo.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.techugo.model.TestingData
import com.example.techugo.retrofit.ApiClient
import retrofit2.Call
import retrofit2.Response

class TabViewModel : ViewModel() {
    private var liveData: MutableLiveData<TestingData> = MutableLiveData()
    val _livedata: LiveData<TestingData>
        get() = liveData

    fun getData() {
        val call: Call<TestingData> = ApiClient.getClient.getData()
        call.enqueue(object : retrofit2.Callback<TestingData> {
            override fun onFailure(call: Call<TestingData>, t: Throwable) {
                Log.d("RepoActivityViewModel", t.message.toString())
            }

            override fun onResponse(
                call: Call<TestingData>,
                response: Response<TestingData>
            ) {
                val data = response.body()
                liveData.postValue(data)
            }

        })
    }
}