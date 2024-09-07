package com.example.sms_mui_compose.network.survey

import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface SurveysAPI {
    @GET("Surveys")
    public suspend fun getAllSurveys():SurveyResponse

    @POST("Surveys")
    public suspend fun addSurvey(survey:Survey):SurveyResponse

    @GET("Surveys/{surveyid}")
    public suspend fun getSurvey(@Path("surveyid")surveyId:Int):SurveyResponse
}