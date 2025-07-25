package com.example.sms_mui_compose.ui.theme.activity.activity

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sms_mui_compose.ui.theme.activity.QuestionType
import java.io.File
@Composable
fun SurveyForm(
    questions: List<com.example.sms_mui_compose.ui.theme.activity.activity.Question>,
    uploadFileToServer: suspend (File) -> Boolean,
    onSubmit: (Map<String, Any?>) -> Unit
) {
    val answers = remember { mutableStateMapOf<String, Any?>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        questions.forEach { question ->
            when (question.type) {
                QuestionType.ShortText -> {
                    var value by remember { mutableStateOf("") }
                    OutlinedTextField(
                        value = value,
                        onValueChange = {
                            value = it
                            answers[question.id] = it
                        },
                        label = { Text(question.text) },
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                QuestionType.ParagraphText -> {
                    var value by remember { mutableStateOf("") }
                    OutlinedTextField(
                        value = value,
                        onValueChange = {
                            value = it
                            answers[question.id] = it
                        },
                        label = { Text(question.text) },
                        modifier = Modifier.fillMaxWidth(),
                        maxLines = 5
                    )
                }

                QuestionType.FileUpload -> {
                    FileUploadQuestion(
                        questionId = question.id,
                        questionText = question.text,
                        allowedMimeTypes = listOf("jpeg","pdf"),
                        maxFileSizeMB = 5,
                        uploadFileToServer = uploadFileToServer,
                        onAnswerChanged = { id, file ->
                            answers[id] = file
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
        }

        Button(onClick = { onSubmit(answers) }) {
            Text("Submit")
        }
    }
}
