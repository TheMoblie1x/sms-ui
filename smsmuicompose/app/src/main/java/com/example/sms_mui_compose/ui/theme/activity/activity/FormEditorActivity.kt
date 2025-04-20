package com.example.sms_mui_compose.ui.theme.activity.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sms_mui_compose.ui.theme.activity.activity.ui.theme.SmsmuicomposeTheme
import androidx.compose.material3.*
import com.example.sms_mui_compose.ui.theme.activity.activity.composables.components.question.QuestionItem
import com.example.sms_mui_compose.ui.theme.activity.activity.composables.components.question.QuestionsListViewModel
import com.example.sms_mui_compose.ui.theme.activity.activity.data.Question
import com.example.sms_mui_compose.ui.theme.activity.activity.data.QuestionsDummyData


class FormEditorActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SmsmuicomposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FormEditorUI(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun FormEditorUI(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text("Welcome to the Form Editor Activity")
        Spacer(modifier = Modifier.height(16.dp))
        TextInputWithAIButton(QuestionsListViewModel())
        Spacer(modifier = Modifier.height(16.dp))
        QuestionList(QuestionsDummyData().getQuestionsData())
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { /*TODO*/ }) {
            Text("Submit")
        }
    }
}

@Composable
fun QuestionList(questions: List<Question>) {
    LazyColumn {
        items(questions) { question ->
            QuestionItem(
                questionTitle = question.questionTitle,
                description = question.description,
                answerType = question.answerType,
                answerList = question.answerList,
                selectedAnswer = question.selectedAnswer,
                onAnswerSelected = { question.onClickListener }
            )
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInputWithAIButton(viewModel: QuestionsListViewModel) {
    var text by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Enter Prompt to generate a Form Using M1x Ai") },
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        if (text.isNotEmpty()) {
            if (viewModel.isLoading) {
                CircularProgressIndicator()
            } else {
                Button(
                    onClick = {
                        viewModel.generateTextWithAI(text)
                    }
                ) {
                    Text("Generate using AI")
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        if (viewModel.generatedText.isNotEmpty()) {
            Text("Generated Text: ${viewModel.generatedText}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FormEditorUIPreview() {
    SmsmuicomposeTheme {
        FormEditorUI()
    }
}