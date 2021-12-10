package com.example.myapplication.architecture

import com.example.myapplication.tp4.remote.Tp4QuoteEndpoint
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private val tp4retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://random-data-api.com/api/address/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()))
        .build()

    fun getTp4Quote(): Tp4QuoteEndpoint = tp4retrofit.create(Tp4QuoteEndpoint::class.java)
}
