package com.example.sms_mui_compose.network.formdata

import com.example.sms_mui_compose.network.surveyset.SurveySet

class FormDataResponse {
    lateinit var data:List<FormData>
    lateinit var message:String
    lateinit var status:String
}
