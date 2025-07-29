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
import androidx.compose.ui.unit.dp
import com.example.sms_mui_compose.ui.theme.activity.QuestionType
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import java.io.File

@Composable
fun SurveyForm(
    questions: List<Question>,
    uploadFileToServer: suspend (File) -> Boolean,
    onSubmit: (Map<String, Any?>) -> Unit
) {
    val answers = remember { mutableStateMapOf<String, Any?>() }
    val questionList = remember { mutableStateOf(questions.toMutableList()) }

    // State for dropdown and text input
    var expanded by remember { mutableStateOf(false) }
    var selectedType by remember { mutableStateOf<QuestionType?>(null) }
    var customQuestionText by remember { mutableStateOf("") }

    val questionTypes = QuestionType.values()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        questionList.value.forEach { question ->
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
                        allowedMimeTypes = listOf("jpeg", "pdf"),
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

        // Dropdown to choose question type
        Box {
            OutlinedTextField(
                value = selectedType?.name ?: "",
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = true },
                readOnly = true,
                label = { Text("Select Question Type") }
            )

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                questionTypes.forEach { type ->
                    DropdownMenuItem(
                        text = { Text(type.name) },
                        onClick = {
                            selectedType = type
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Enter question label
        OutlinedTextField(
            value = customQuestionText,
            onValueChange = { customQuestionText = it },
            label = { Text("Question Text") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                if (selectedType != null && customQuestionText.isNotBlank()) {
                    val newQuestion = Question(
                        id = "q${questionList.value.size + 1}",
                        text = customQuestionText,
                        type = selectedType!!
                    )
                    questionList.value.add(newQuestion)
                    // Reset state
                    selectedType = null
                    customQuestionText = ""
                }
            }
        ) {
            Text("Add Question")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { onSubmit(answers) }) {
            Text("Submit")
        }
    }
}
