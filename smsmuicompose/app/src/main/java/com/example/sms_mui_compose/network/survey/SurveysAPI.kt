package com.example.sms_mui_compose.network.survey

import retrofit2.http.GET

interface SurveysAPI {
    @GET("Surveys")
    public suspend fun getAllSurveys():SurveyResponse
}