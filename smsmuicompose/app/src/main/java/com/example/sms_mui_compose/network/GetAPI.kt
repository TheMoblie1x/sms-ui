package com.example.sms_mui_compose.network

import com.example.sms_mui_compose.APIClient

class GetAPI {

    companion object{
        inline fun<reified T> getAPIForClass(t:T): T {
            val apiClient = APIClient.get()
            val api = apiClient.create(T::class.java)
            return api
        }

    }
}