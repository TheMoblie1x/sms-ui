package com.example.sms_mui_compose.ui.theme.activity

enum class QuestionType {
    ShortText, ParagraphText, FileUpload
}

data class Question(
    val id: String,
    val text: String,
    val type: QuestionType,
    val allowedMimeTypes: List<String> = emptyList(),
    val maxFileSizeMB: Int = 5
)
