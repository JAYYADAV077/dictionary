package com.example.dic.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiCall {
    @GET("api/v1/entries/{language}/{word}")
    suspend fun getEntry(
        @Path("language") language: String,
        @Path("word") word: String
    ): Response<ApiDataClass>
}