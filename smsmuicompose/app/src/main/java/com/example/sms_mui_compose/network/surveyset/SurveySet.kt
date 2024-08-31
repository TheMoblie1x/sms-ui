package com.example.sms_mui_compose.network.surveyset

class SurveySet {
    var surveySetId:Int = 0
    lateinit var description:String
    lateinit var name:String
    lateinit var creationDate:String
    var groupId:Int = 0
    lateinit var groupName:String
    override fun toString(): String {
        return "SurveySet(surveySetId=$surveySetId, description='$description', name='$name', creationDate='$creationDate', groupId=$groupId, groupName='$groupName')"
    }

}
