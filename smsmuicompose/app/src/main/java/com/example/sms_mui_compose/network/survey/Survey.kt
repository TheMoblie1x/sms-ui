package com.example.sms_mui_compose.network.survey

public class Survey {
    var surveyId:Int = 0
    lateinit var title:String
    lateinit var status:String
    lateinit var description:String
    lateinit var releaseDate:String
    lateinit var expiryDate:String
    var surveySetId:Int = 0
    var surveyManagerId:Int = 0
    override fun toString(): String {
        return "Survey(surveyId=$surveyId, title='$title', status='$status', description='$description', releaseDate='$releaseDate', expiryDate='$expiryDate', surveySetId=$surveySetId, surveyManagerId=$surveyManagerId)"
    }

}
