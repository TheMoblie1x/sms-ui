package com.example.sms_mui_compose.network.company

import retrofit2.http.GET

interface CompaniesAPI {

    @GET("Companies")
    suspend fun getAllCompanies():CompanyResponse
}