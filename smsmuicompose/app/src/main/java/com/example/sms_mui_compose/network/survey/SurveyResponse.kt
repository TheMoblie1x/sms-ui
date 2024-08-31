package com.example.sms_mui_compose.network.survey

import com.example.sms_mui_compose.network.company.Company

class SurveyResponse {
    lateinit var data:List<Survey>
    lateinit var message:String
    lateinit var status:String
}
