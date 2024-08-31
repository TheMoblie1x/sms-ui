package com.example.sms_mui_compose.network.formdata

import retrofit2.http.GET
import retrofit2.http.POST

interface FormDataAPI {
    @POST("FormData")
    suspend fun createForm(formData:FormData)

    @GET("FormDatas")
    suspend fun getFormDataList(): List<FormDataResponse>

}