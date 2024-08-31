package com.example.sms_mui_compose.network.formdata

class FormData {

//    formTitle: formTitle
//    formDescription: formDescription
//    questionCount: questionCount
//    questions: formattedQuestions
//    surveySet: surveySetId
//    createdAt: currentTimestamp
//    updatedAt: currentTimestamp
//    viewCount: 0
//    createdBy: name
//    updatedBy: name
//    isActive: "True"
//    isPublished: "True"
//    publishedAt: currentTimestamp
//    expirationDate: "2124-04-23"
//    submissionCount: 5
//    responseCount: 7
//    tags: ["Tag1" "Tag2"]
//    category: "Company Survey"
//    language: "English"
//    accessibility: "True"
//    hasAttachments: "False"
//    isAIGenerated: "False"
//    isScanned: "False"
//    active: "False"
//    published: "False"
//    scanned: "False"

    lateinit var formTitle: String
    lateinit var formDescription: String
    var questionCount: Int = 0
    lateinit var questions : List<Question>
    var surveySet: Int = 0
    lateinit var createdAt: String
    lateinit var updatedAt: String
    var viewCount: Int = 0
    lateinit var createdBy: String
    lateinit var updatedBy: String
    //lateinit var isActive: String //Boolean String
    //lateinit var isPublished: String //Boolean String
    lateinit var publishedAt: String //Boolean String
    lateinit var expirationDate: String //Boolean Date
    var submissionCount: Int = 0
    var responseCount: Int = 0
    lateinit var tags: Array<String>
    lateinit var category: String
    lateinit var language: String
    lateinit var accessibility: String //Boolean String
    lateinit var hasAttachments: String //Boolean String
    lateinit var isAIGenerated: String //Boolean String
    //lateinit var isScanned: String //Boolean String
    lateinit var active: String //Boolean String
    lateinit var published: String //Boolean String
    lateinit var scanned: String //Boolean String
}