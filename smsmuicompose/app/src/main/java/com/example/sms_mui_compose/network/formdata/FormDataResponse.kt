package com.example.sms_mui_compose.network.formdata

import com.example.sms_mui_compose.network.surveyset.SurveySet

class FormDataResponse {
    var data:List<FormData>? = null
    lateinit var message:String
    lateinit var status:String
}
