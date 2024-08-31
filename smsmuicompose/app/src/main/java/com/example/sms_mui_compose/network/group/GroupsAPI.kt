package com.example.sms_mui_compose.network.group

import com.example.sms_mui_compose.network.API
import retrofit2.http.GET
import retrofit2.http.Path

interface GroupsAPI : API {
    @GET("company/{id}/Group")
    suspend fun getGroupByCompanyID(@Path("id") companyId: Int): GroupResponse
}