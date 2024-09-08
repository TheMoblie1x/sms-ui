package com.example.sms_mui_compose.network.surveyset

import retrofit2.http.GET
import retrofit2.http.Path

interface SurveySetsAPI {

    @GET("SurveySetsByGroupId/{groupId}")
    suspend fun getSurveySetsByGroupId(@Path("groupId") groupId: Int): SurveySetsResponse

}