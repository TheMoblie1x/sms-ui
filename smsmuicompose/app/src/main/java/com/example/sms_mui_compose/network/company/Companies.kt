package com.example.sms_mui_compose.network.company

//import com.example.sms_mui_compose.Constants.Companion.GET_COMPANIES
import retrofit2.http.GET

interface Companies {

    @GET("Companies")
    suspend fun getAllCompanies():CompanyResponse
}