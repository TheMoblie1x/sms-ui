package com.example.sms_mui_compose.network.formdata

class Question {
//    var questionTitle: title
//    var questionType: type
//    var options: type !== 'toffee' ? options.join('') : null
//    var questionNumber: index + 1
//    var fontColor: style.fontColor || '#000000'
//    var fontFamily: style.fontFamily
//    var bold: style.bold
//    var italic: style.italic
//    var underlined: style.underlined
//    var mandatory: flagged

    lateinit var questionTitle:String
    lateinit var questionType: String
    lateinit var options: String
    var questionNumber: Int = 0//index + 1
    lateinit var fontColor: String//style.fontColor || '#000000'
    lateinit var fontFamily: String//style.fontFamily
    lateinit var bold: String //..style.bold
    lateinit var italic: String //style.italic
    lateinit var underlined: String//style.underlined
    lateinit var mandatory: String//flagged
}