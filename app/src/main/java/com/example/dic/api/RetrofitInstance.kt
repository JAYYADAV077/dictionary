package com.example.dic.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    const val BASEURL = "https://freedictionaryapi.com/"

    val obj: Retrofit = Retrofit.Builder() //retrofit obj
        .baseUrl(BASEURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiInterfaceObj: ApiCall =  obj.create(ApiCall::class.java)

}