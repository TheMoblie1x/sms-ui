package com.example.sms_mui_compose.ui.theme.activity.activity.data

import com.example.sms_mui_compose.ui.theme.activity.activity.enums.AnswerType

data class Question(
    var questionTitle: String,
    var description: String,
    var answerType: AnswerType,
    var answerList: List<String>,
    var selectedAnswer: String,
    var onClickListener: () -> Unit
)