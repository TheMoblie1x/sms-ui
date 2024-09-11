package com.example.sms_mui_compose.network.survey

import com.example.sms_mui_compose.network.company.Company

class SurveyResponse {
    var data:List<Survey>? = null
    lateinit var message:String
    lateinit var status:String
}
