package com.example.aplicationdetik.service

import com.example.aplicationdetik.model.ResponeNews
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

object RetrofitBuilder {

    private val client: OkHttpClient = OkHttpClient.Builder().build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://newsapi.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun getService() = retrofit.create(TopHeadLine::class.java)

    interface TopHeadLine {
        @Headers ("Authorization: 76648387b09c447e9f78af7c711f312c")
        @GET("v2/top-headlines?country=id")

        fun feachHeadlines(): Call<ResponeNews>

    }


}