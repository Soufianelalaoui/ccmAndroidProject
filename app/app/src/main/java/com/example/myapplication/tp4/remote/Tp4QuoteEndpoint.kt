package com.example.myapplication.tp4.remote

import com.example.myapplication.tp4.model.Tp4Retrofit
import retrofit2.http.GET

interface Tp4QuoteEndpoint {
    @GET("random_address")
    suspend fun getRandomQuote() : Tp4Retrofit

}