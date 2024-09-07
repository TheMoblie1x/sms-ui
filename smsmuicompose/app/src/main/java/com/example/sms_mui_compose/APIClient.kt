package com.example.sms_mui_compose

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {
    companion object RetrofitInstance {
        fun get():Retrofit{
            return Retrofit.Builder().baseUrl("http://35.154.109.58:8080/").addConverterFactory(
                GsonConverterFactory.create()).build()
        }

//        fun get():Retrofit{
//            return Retrofit.Builder().baseUrl("http://127.0.0.1:8080/").addConverterFactory(
//                GsonConverterFactory.create()).build()
//        }
    }
}